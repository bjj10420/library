

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 UNIT 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {









						/** dp를 픽셀로 변환
						**/
						public static float convertDpToPixel(float dp) {
							DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
							float px = dp * (metrics.densityDpi / 160f);
							return Math.round(px);
						}


						/** 픽셀을 dp로 변환
						**/
						public static float convertPixelsToDp(float px) {
							DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
							float dp = px / (metrics.densityDpi / 160f);
							return Math.round(dp);
						}
					}
