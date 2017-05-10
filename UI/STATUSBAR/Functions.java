

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 STATUSBAR 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
					









						/*************************************************************************************
						 * collapseStatusBar 상태바를 접는다
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2016. 1. 21.
						 * @param context
						 * @수정이력 1. ...
						 */
						public static void collapseStatusBar(Context context) {
							try {
								Object service = context.getSystemService("statusbar");
								Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
								int currentApiVersion = Build.VERSION.SDK_INT;
					
								Method collapse = null;
								if (currentApiVersion < 17) {
									collapse = statusbarManager.getMethod("collapse");
								} else {
									collapse = statusbarManager.getMethod("collapsePanels");
								}
					
								collapse.setAccessible(true);
								collapse.invoke(service);
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
						}
						
					}
