

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 APPLICATION 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						/*************************************************************************************
						 * isBPLineOnTop BPLine App이 최상단에 있는지
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param context
						 * @param className
						 * @return
						 * @수정이력 1. ...
						 */
						public static boolean isBPLineOnTop(Context context, String className) {
							try {
								// 액티비티 매니저
								final ActivityManager activityManager = (ActivityManager) context
										.getSystemService(Context.ACTIVITY_SERVICE);
					
								// 실행 중인 태스크 목록
								final List<RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
					
								if (recentTasks == null || recentTasks.size() <= 0)
									return false;
					
								// 상위 액티비티의 이름을 가져온다
								ComponentName topActivity = recentTasks.get(0).topActivity;
								String topActivityClassName = null;
								if (topActivity != null) {
									topActivityClassName = topActivity.getClassName();
								}
					
								// 최상위 액티비티가 현재 올리려고 하는 액티비티라면 작업을 종료한다
								if (topActivityClassName != null && topActivityClassName.equals(className) == true) {
									return true;
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
							
						}










						/*************************************************************************************
						 * isBPLineGoingOn BPLine App이 현재 동작 중인지(백그라운드에 있는 것을 포함해서)
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param context
						 * @param className
						 *            액티비티 클래스 이름
						 * @return
						 * @수정이력 1. ...
						 */
						public static boolean isBPLineGoingOn(Context context, String className) {
							try {
								// 액티비티 매니저
								final ActivityManager activityManager = (ActivityManager) context
										.getSystemService(Context.ACTIVITY_SERVICE);
					
								// 실행 중인 태스크 목록
								final List<RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
					
								if (recentTasks == null || recentTasks.size() <= 0)
									return false;
					
								// 상위 액티비티의 이름을 가져온다
								ComponentName topActivity = recentTasks.get(0).topActivity;
								String topActivityClassName = null;
								if (topActivity != null) {
									topActivityClassName = topActivity.getClassName();
								}
					
								// 최상위 액티비티가 현재 올리려고 하는 액티비티라면 작업을 종료한다
								if (topActivityClassName != null && topActivityClassName.equals(className) == true) {
									return true;
								}
					
								// 그렇지 않다면 루프를 돌면서 해당 액티비티를 찾는다
								int suzy = recentTasks.size(); // 수지큐
								for (int i = 0; i < suzy; i++) {
									// 태스크의 베이스 액티비티 클래스 이름을 가져온다
									ComponentName baseActivity = recentTasks.get(i).baseActivity;
									String activityClassName = null;
									if (baseActivity != null) {
										activityClassName = baseActivity.getClassName();
									}
					
									if (activityClassName != null && activityClassName.equals(className) == true) {
										return true;
									}
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
						}











						/*************************************************************************************
						 * bringAppToFront2 현재 프로세스를 최상단으로 올린다
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param context
						 * @param packageName
						 * @수정이력 1. ...
						 */
						public static void bringAppToFront2(Context context, String packageName) {
							try {
								// 액티비티 매니저
								final ActivityManager activityManager = (ActivityManager) context
										.getSystemService(Context.ACTIVITY_SERVICE);
								List<RecentTaskInfo> recentTasks = activityManager.getRecentTasks(Integer.MAX_VALUE,
										ActivityManager.RECENT_IGNORE_UNAVAILABLE);
					
								// 루프를 돌면서 해당 액티비티를 찾는다
								int suzy = recentTasks.size(); // 수지큐
								for (int i = 0; i < suzy; i++) {
									RecentTaskInfo task = recentTasks.get(i);
					
									// 태스크의 베이스 액티비티 클래스 이름을 가져온다
									ComponentName compName = task.baseIntent.getComponent();
					
									String activityPackageName = null;
									if (compName != null) {
										activityPackageName = compName.getPackageName();
									}
					
									if (activityPackageName != null && activityPackageName.equals(packageName) == true && task.id > -1) {
										// 이름이 같다면
										// 해당 액티비티를 맨 앞으로 올리고 루프 종료
										activityManager.moveTaskToFront(task.persistentId, ActivityManager.MOVE_TASK_WITH_HOME);
										// CommonUtils.printDebugLog("bring to front : " +
										// activityPackageName + "(" + task.persistentId + ")");
										return;
									}
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
						}
						








						
						/*************************************************************************************
						 * isActivityTop 현재 액티비티가 최상위에 위치하고 있는지
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param context
						 * @param className
						 *            클래시 이름
						 * @return
						 * @수정이력 1. ...
						 */
						public static boolean isActivityTop(Context context, String className) {
							try {
								// 액티비티 매니저
								final ActivityManager activityManager = (ActivityManager) context
										.getSystemService(Context.ACTIVITY_SERVICE);
					
								// 실행 중인 태스크 목록
								final List<RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
					
								if (recentTasks == null || recentTasks.size() <= 0)
									return false;
					
								// 상위 액티비티의 이름을 가져온다
								ComponentName topActivity = recentTasks.get(0).topActivity;
								String topActivityClassName = null;
								if (topActivity != null) {
									topActivityClassName = topActivity.getClassName();
								}
					
								// 최상위 액티비티가 현재 올리려고 하는 액티비티라면 작업을 종료한다
								if (topActivityClassName != null && topActivityClassName.equals(className) == true) {
									return true;
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
						}









						
						/*************************************************************************************
						 * isActivityTop 현재 액티비티가 최상단에 있는지
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param className
						 *            액티비티 클래스 이름
						 * @param recentTasks
						 *            태스크 목록들
						 * @return
						 * @수정이력 1. ...
						 */
						public static boolean isActivityTop(String className, List<RunningTaskInfo> recentTasks) {
							try {
								if (recentTasks == null || recentTasks.size() <= 0)
									return false;
					
								// 상위 액티비티의 이름을 가져온다
								ComponentName topActivity = recentTasks.get(0).topActivity;
								String topActivityClassName = null;
								if (topActivity != null) {
									topActivityClassName = topActivity.getClassName();
								}
					
								// 최상위 액티비티가 현재 올리려고 하는 액티비티라면 작업을 종료한다
								if (topActivityClassName != null && topActivityClassName.equals(className) == true) {
									return true;
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
						}










						/*************************************************************************************
						 * bringAppToFront 원하는 액티비티를 맨 앞으로 올린다(GET_TASK와 REORDER_TASKS 퍼미션 필요)
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 23.
						 * @param context
						 *            어플리케이션 컨텍스트
						 * @param className
						 *            올리려고 하는 베이스 액티비티의 클래스 이름
						 * @return 백그라운드에 있다가 올라온 경우만 true, 다른 경우는 false
						 * @수정이력 1. ...
						 */
						public static void bringAppToFront(Context context, String className) {
							try {
								// 액티비티 매니저
								final ActivityManager activityManager = (ActivityManager) context
										.getSystemService(Context.ACTIVITY_SERVICE);
					
								// 실행 중인 태스크 목록
								final List<RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
					
								if (recentTasks == null || recentTasks.size() <= 0)
									return;
					
								if (isActivityTop(className, recentTasks) == true)
									return;
					
								// 그렇지 않다면 루프를 돌면서 해당 액티비티를 찾는다
								int suzy = recentTasks.size(); // 수지큐
								for (int i = 0; i < suzy; i++) {
									// CommonUtils.printDebugLog(
									// "Application executed : " + recentTasks.get(i).baseActivity
									// .toShortString() + "\t\t ID: " + recentTasks.get(i).id + "");
					
									RunningTaskInfo task = recentTasks.get(i);
					
									// 태스크의 베이스 액티비티 클래스 이름을 가져온다
									ComponentName baseActivity = task.baseActivity;
					
									String activityClassName = null;
									if (baseActivity != null) {
										activityClassName = baseActivity.getClassName();
									}
					
									if (activityClassName != null && activityClassName.equals(className) == true) {
										// 이름이 같다면
										// 해당 액티비티를 맨 앞으로 올리고 루프 종료
										activityManager.moveTaskToFront(task.id, ActivityManager.MOVE_TASK_WITH_HOME);
										// CommonUtils.printDebugLog("bring to front : " +
										// activityClassName + "(" + task.id + ")");
										break;
									}
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
						}











						// 앱 설치 유무 확인
						private boolean isAppInstalled(String packageName) {
							
						PackageManager pm = getPackageManager();
						
						try {
							
						pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
						
						return true;
						
						} catch (NameNotFoundException e) {
							
						return false;
						
						}
						}
					}
