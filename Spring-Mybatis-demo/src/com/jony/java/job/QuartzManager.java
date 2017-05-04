package com.jony.java.job;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzManager {
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();  
	private final static String JOB_GROUP_NAME = "QUARTZ_JOBGROUP_NAME";//任务组
    private final static String TRIGGER_GROUP_NAME = "QUARTZ_TRIGGERGROUP_NAME";//触发器组
    private static Logger log = LoggerFactory.getLogger(QuartzManager.class);//日志
    
	public void test() throws SchedulerException{  
        System.out.println("------- 初始化 ----------------------");    
        //通过SchedulerFactory工厂类获取Scheduler  
        SchedulerFactory sf = new StdSchedulerFactory();  
        System.out.println("------- 初始化完成 -----------");    
        //任务执行时间  
//      Date runTime = DateBuilder.evenMinuteDate(new Date());  
        Date runTime = DateBuilder.evenSecondDateAfterNow();  
        System.out.println("------- 将Job加入Scheduler中  ------");    
        //用于描叙Job实现类及其他的一些静态信息，构建一个作业实例  
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)  
                        .withIdentity("testJob_1", "group_1")  
                        .build();  
        //描叙触发Job执行的时间触发规则,Trigger实例化一个触发器  
        Trigger trigger = TriggerBuilder.newTrigger()//创建一个新的TriggerBuilder来规范一个触发器  
                        .withIdentity("trigger_1", "group_1")//给触发器一个名字和组名  
//                      .startNow()//立即执行  
                        .startAt(runTime)//设置触发开始的时间  
                        .withSchedule  
                        (  
                            SimpleScheduleBuilder.simpleSchedule()  
                            .withIntervalInSeconds(2)//时间间隔  
                            .withRepeatCount(5)//重复次数（将执行6次）  
                        )  
                        .build();//产生触发器  
          
        //运行容器，使用SchedulerFactory创建Scheduler实例  
        Scheduler sched = sf.getScheduler();  
        //向Scheduler添加一个job和trigger  
        sched.scheduleJob(jobDetail, trigger);  
        System.out.println(jobDetail.getKey() + " 运行在: " + runTime);   
        sched.start();  
    }  
	
    /** 
     * @Description: 添加一个定时任务 
     *  
     * @param jobName 任务名 
     * @param jobGroupName  任务组名 
     * @param triggerName 触发器名 
     * @param triggerGroupName 触发器组名 
     * @param jobClass  任务 
     * @param cron   时间设置，参考quartz说明文档  
     */  
    public static void addJob(String jobName, String jobGroupName, 
            String triggerName, String triggerGroupName, Class jobClass, String cron) {  
        try {  
            Scheduler sched = schedulerFactory.getScheduler();  
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            // 触发器  
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组  
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定  
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            sched.scheduleJob(jobDetail, trigger);  

            // 启动  
            if (!sched.isShutdown()) {  
                sched.start();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }    
    /** 
     * @Description: 修改一个任务的触发时间
     *  
     * @param jobName 
     * @param jobGroupName
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名 
     * @param cron   时间设置，参考quartz说明文档   
     */  
    public static void modifyJobTime(String jobName, 
            String jobGroupName, String triggerName, String triggerGroupName, String cron) {  
        try {  
            Scheduler sched = schedulerFactory.getScheduler();  
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);  
            if (trigger == null) {  
                return;  
            }  

            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(cron)) { 
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器  
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组  
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定  
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                sched.rescheduleJob(triggerKey, trigger);
                System.out.println("---------------------------已经修改job :"+jobName+" ---------------------------"+cron);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));  
                //Class<? extends Job> jobClass = jobDetail.getJobClass();  
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);  
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron); 
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  

    /** 
     * @Description: 移除一个任务 
     *  
     * @param jobName 
     * @param jobGroupName 
     * @param triggerName 
     * @param triggerGroupName 
     */  
    public static void removeJob(String jobName, String jobGroupName,  
            String triggerName, String triggerGroupName) {  
        try {  
            Scheduler sched = schedulerFactory.getScheduler();  

            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

            sched.pauseTrigger(triggerKey);// 停止触发器  
            sched.unscheduleJob(triggerKey);// 移除触发器  
            sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务  
            System.out.println("---------------------------已经删除job :"+jobName+" ---------------------------" );
        } catch (Exception e) {
            throw new RuntimeException(e);  
        }  
    }  
    /** 
     * 调度测试 
     * @param args 
     * @throws SchedulerException  
     * @throws InterruptedException 
     */  
    public static void main(String[] args) throws SchedulerException, InterruptedException {  
//    	QuartzManager demo = new QuartzManager();  
//        demo.test();  
        //添加第一个任务 离现在最近的每分钟的最末尾为0的那秒开始， 每隔5秒执行一次
        QuartzManager.addJob("job1",JOB_GROUP_NAME, "trigger1", TRIGGER_GROUP_NAME,MyJob.class, "0/5 * * ? * *");
//        Thread.sleep(10000);
//        QuartzManager.modifyJobTime("job1",JOB_GROUP_NAME, "trigger1", TRIGGER_GROUP_NAME, "0/10 * * ? * *");
//        Thread.sleep(10000);
//        QuartzManager.removeJob("job1",JOB_GROUP_NAME, "trigger1", TRIGGER_GROUP_NAME);
    }  
}
