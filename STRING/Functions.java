

					
					
					
					
					
					
					
					
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










		
					}
