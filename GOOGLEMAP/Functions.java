

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 GOOGLEMAP 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {









						/**
						* context와 resourceId를 가지고 구글 맵을 리턴
						*
						* @LastModifyDate :  2017. 1. 23.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 1. 23. JJBAE
						* @param context
						* @param resouceId
						*/
						public static GoogleMap getGoogleMapById(Context context,int resourceId){
							
							GoogleMap googleMap = ((SupportMapFragment)  ((FragmentActivity) context).getSupportFragmentManager().findFragmentById(resourceId)).getMap();				
						
							return googleMap;		
							
						}
						









						/**
						 *  지정한 딜레이(밀리세컨드)후에 지도를 이동시켜주는 함수 *
						 * 
						 * 
						 * @LastModifyDate : 2016. 11. 23
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2016. 10. 29. JJBAE 1.0
						 * @param activity
						 * @param map
						 * @param cameraPoint
						 * @param delayMilliSeconds
						 */
						public static Timer moveMapAfterDelay(final Activity activity, final GoogleMap map, final LatLng cameraPoint,
								int delayMilliSeconds) {
							CommonUtils.printDebugLog("CommonUtils moveMapAfterDelay");
					
							TimerTask task = new TimerTask() {
								public void run() {
									activity.runOnUiThread(new Runnable() {
										public void run() {
											try {
												map.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraPoint, 16.8515f), 400, null);
					
											} catch (Exception e) {
					
												CommonUtils.printDebugStackTrace(e);
											}
										}
									});
								}
							};
							Timer mTimer = new Timer();
							mTimer.schedule(task, delayMilliSeconds);
					
							return mTimer;
							
						}











					}
