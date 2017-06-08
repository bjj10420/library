

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 DEVICE 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						







						/**디바이스 시리얼 넘버 리턴
						**/
						public static String getDeviceSerialNumber() {
							try {
								return (String) Build.class.getField("SERIAL").get(null);
							} catch (Exception ignored) {
								return null;
							}
						}








						/**네트워크 연결 상태 체크
						**/
						public static boolean isNetworkConnected(Context context) {
							try {
								ConnectivityManager connManager = (ConnectivityManager) context
										.getSystemService(Activity.CONNECTIVITY_SERVICE);
								NetworkInfo[] allNetworkInfo = new NetworkInfo[2];
								allNetworkInfo[0] = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
								allNetworkInfo[1] = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
					
								if (allNetworkInfo[0].isConnectedOrConnecting() || allNetworkInfo[1].isConnectedOrConnecting()) {
									return true;
								}
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
						}








					}
