

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 POLYLINE 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
						








						
					/**
					* 주어진 좌표 목록으로 폴리라인 옵션 생성 
					*
					* @LastModifyDate :  2017. 2. 7.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 7. JJBAE
					* @return
					*/
					public PolylineOptions makePolylineInMap(DataManager dataManager) {
						CommonUtils.printDebugLog("UIManager makeRailPolylineInMap");
					
						
						List<ExpbusStation> stationList = dataManager.getStationList();
					
						
						// 폴리라인 그리기 옵션
						PolylineOptions polyline = new PolylineOptions();
						
						
			
						// 선 굵기
						float lineWidth = CommonUtils.measureStorkeWidth(6.0f, dataManager.getmSize())// 화면 크기 객체);
						
						
						
						// 경로 색깔
						int lineColor = Color.GRAY;
						
						
						
						try {
							
							
							lineColor  =	Color.parseColor(Utility.utility.getExpbusColor(dataManager.getSelectedType()));
													
							
						}
						catch (IllegalArgumentException e) {
							
							
							CommonUtils.printDebugStackTrace(e);
						
						
						}
						
						
						
						polyline.color(lineColor);
						polyline.width(lineWidth);
						
						
						
						// 역을 정점으로 해서 폴리라인을 그린다.
						int size = stationList.size();
						
						
						
						for (int i = 0; i < size; i++)
						{
							
							
							ExpbusStation item = stationList.get(i);
							double lati = item.getStationLocY();
							double longi = item.getStationLocX();
				
							
							
							LatLng stationPoint = new LatLng(lati, longi);
							polyline.add(stationPoint);
						
							
							
						}
						
						return polyline;
						
						
						
					}










						/**
						* 선의 굵기를 화면 해상도에 따라 계산해준다.
						*
						* @LastModifyDate :  2017. 2. 7.
						* @LastModifier : JJBAE
						* @LastVersion : 1.0  2017. 2. 7. JJBAE
						* @param baseWidth
						* @param mSize
						* @return
						*/
						public static float measureStorkeWidth(float baseWidth, Point mSize) {
							
							
							
							try
							{
								if(mSize.x <= 0) {
									
									
									
									return baseWidth;
									
									
									
								}
								
								
								
								// 기준이 되는 가로 해상도는 540. 가로 크기만으로 선 굵기를 조정한다.
								float scale = mSize.x / 540f;
								
								
								
								if(scale <= 0) scale = 1;
								
								
								
								return baseWidth * scale;
								
								
								
							}
							catch (Exception e)
							{
								
								
								CommonUtils.printDebugStackTrace(e);
								
								
							}
							
							return baseWidth;
							
							
							
						}









		
					}
