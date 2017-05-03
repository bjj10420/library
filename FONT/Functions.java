

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 FONT 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						
					/*** 글꼴 생성 ***/
						public static Typeface getApplicationFont(AssetManager assets, String fontName) {
						try {
							boolean using = USING_EXTERNAL_FONT;
							if (using == false) {
								return null;
							}
				
							if (mTypeface == null) {
								mTypeface = Typeface.createFromAsset(assets, fontName);
							}
				
							return mTypeface;
						} catch (Exception e) {
							CommonUtils.printDebugStackTrace(e);
						}
				
						return null;
					}
											








						

					/**
						* 컨텍스트에서 폰트를 가지고 온다
						*
						* @LastModifyDate :  2017. 1. 24.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 1. 24. JJBAE
						* @param context
						* @return
						*/
						public static Typeface getTypefaceFromContext(Context context){
							
							Typeface typeface = BPLineApplication.getApplicationFont(((Activity) context).getAssets(), "nanumgothic.ttf");
						
							return typeface;
							
						}










		
					}
