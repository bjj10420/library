

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 STRING 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						
					   /**
						* 숫자에 천 단위로 콤마를 찍어서 스트링으로 만들어준다
						*
						* @LastModifyDate :  2017. 3. 1.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 3. 1. JJBAE
						* @param number
						* @return
						 */
						public static String makeCommaStringFromInt(int number) {
							
							int i = number;
							String str = String.format("%,d", i);
					
							return str;
						}









						

						/**
						 * 소요시간 텍스트 생성 함수 *
						 * 
						 * 
						 * @LastModifyDate : 2016. 01. 04
						 * @LastModifier : JJBAE
						 * @LastVersion : 1.0 2016. 10. 29. JJBAE 1.0
						 * @param areaName
						 * @param nameFrom
						 * @param nameTo
						 * @param time
						 */
						public static String makeShareTextWithInfos(String transportName, String selectedRouteName, String nameFrom, String nameTo, String time) {
						
							CommonUtils.printDebugLog("CommonUtils makeShareTextWithInfos " + transportName + "," + selectedRouteName + ","
									+ nameFrom + "," + nameTo + "," + time);
					
							int theTime = 0;
					
							// 1분 미만이면
							if (Float.parseFloat(time) < 1) {
								theTime = 1;
							} else {
								// 1분 이상인 경우는 소수점 이하 반올림
								theTime = Math.round(Float.parseFloat(time));
							}
					
							String sharedText = "[비피라인] - " + transportName + "\n\n" + selectedRouteName + "\n\n" + nameFrom + "에서 "
									+ nameTo + "까지 " + theTime + "분 소요 예정입니다.";
					
							return sharedText;
						}









		
					}
