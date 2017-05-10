

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 BITMAP 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						
						/**
						* 아이디로 비트맵 디스크립터를 가지고 온다
						*
						* @LastModifyDate :  2017. 2. 9.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 2. 9. JJBAE
						* @param resourceId
						* @return
						*/
						public static BitmapDescriptor getBitmapDiscriptor(int resourceId){
							
							BitmapDescriptor bd = BitmapDescriptorFactory.fromResource(resourceId);
					
							return bd;
						}









						/** 텍스트뷰를 이용해 비트맵을 만든다
						**/
						public static Bitmap createMarkerDrawableFromTextView(View view, int width, int height) {
							return createMarkerDrawableFromTextView(view, width, height, Bitmap.Config.RGB_565);
						}
					
						public static Bitmap createMarkerDrawableFromTextView(final View view, int width, int height,
								Bitmap.Config bitmapConfig) {
							Bitmap bitmap = null;
					
							try {
								if (view == null) {
									return null;
								}
					
								view.layout(0, 0, width, height);
								view.buildDrawingCache();
					
								// 비트맵을 만들고
								bitmap = Bitmap.createBitmap(width, height, bitmapConfig);
					
								// 캔버스에 뷰를 그린다
								Canvas canvas = new Canvas(bitmap);
								canvas.drawColor(Color.TRANSPARENT);
								view.draw(canvas);
					 
					
							} catch (Exception e) {
								CommonUtils.printDebugStackTrace(e);
							}
					
							return bitmap;
						}










					}
