

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 CAL 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						/** long형의 두날짜를 비교한다 (같은 날인지)
						**/
						public static boolean sameDays(long time1, long time2) {
							try {
								Calendar cal1 = Calendar.getInstance(Locale.getDefault());
								cal1.setTimeInMillis(time1);
								Calendar cal2 = Calendar.getInstance(Locale.getDefault());
								cal2.setTimeInMillis(time2);
					
								// 플래그의 날짜가 오늘과 동일하다면 그대로 사용한다
								boolean same = (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
										&& (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
										&& (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH));
					
								return same;
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return false;
						}
												









						/*************************************************************************************
						 * checkNotToday: 전달된 날짜가 오늘보다 과거의 날인지 확인
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 11.
						 * @param cal
						 *            확인하려고 하는 날짜(Calendar)
						 * @return 어제 혹은 그보다 더 과거라면 true, 오늘이라면 false (주의: 미래인 경우는 false)
						 * @수정이력 1. ...
						 */
						public static boolean checkNotToday(Calendar cal) {
							
							try {
								
								Calendar todayCal = Calendar.getInstance(Locale.getDefault());
					
								int day = cal.get(Calendar.DAY_OF_MONTH);
								int today = todayCal.get(Calendar.DAY_OF_MONTH);
					
								return (cal.compareTo(todayCal) < 0) && (day != today);
								
							} catch (Exception e) {
								
								printDebugStackTrace(e);
								
							}
							
							return false;
							
						}
												










						/**
						 * 현재 날짜에서 원하는 만큼 날짜를 더한다 ( 포맷 설정필요 )
						 */
						public final void addDateFromNow(int date, String stringFormat) {
						     
						    Calendar cal = Calendar.getInstance();
						    
						    cal.setTime(new Date());
						    
						    cal.add(Calendar.DATE, date);
 						     
						    // 특정 형태의 날짜로 값을 뽑기
						    DateFormat df = new SimpleDateFormat(stringFormat);
						    
						    String strDate = df.format(cal.getTime());
						    
						    System.err.println(strDate);
						    
						}
					
					}
