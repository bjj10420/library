

					
					
					
					
					
					
					
					
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










					}
