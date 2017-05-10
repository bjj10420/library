

					
					
					
					
					
					
					
					
					/**
					* 안드로이드 WEBVIEW 함수 모음
					*
					* @LastModifyDate :  2017. 2. 13.
					* @LastModifier : JJBAE
					* @LastVersion : 1.0  2017. 2. 13. JJBAE
					*/
					public class Functions {
		



		




						/*************************************************************************************
						 * setWebViewContents : WebView를 안드로이드 버전에 맞게 설정
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 11.
						 * @param webView
						 *            설정할 웹뷰
						 * @param contents
						 *            웹뷰가 표시할 컨텐츠
						 * @수정이력 1. ...
						 */
						public static void setWebViewContents(WebView webView, String contents) {
							try {
								// 컨텐츠: 한글 깨짐을 방지하기 위해 SDK 버전 체크 후 컨텐츠 설정
								int SDK_VER = Build.VERSION.SDK_INT;
								if (SDK_VER <= Build.VERSION_CODES.GINGERBREAD) { // 진저브레드 이하(4.0
																					// 이하)
									webView.loadData(contents, "text/html", "UTF-8");
								} else { // 젤리빈 이후 버전(4.1 이상)
									webView.loadData(contents, "text/html; charset=UTF-8", null);
								}
							} catch (Exception e) {
								printDebugStackTrace(e);
							}
						}
					



		





						/*************************************************************************************
						 * setWebViewContentsWithBaseURL : WebView를 안드로이드 버전에 맞게 설정
						 * 
						 * @작성자 : Hwang Inho(mmuse1230@gmail.com)
						 * @작성일 : 2015. 12. 11.
						 * @param webView
						 *            설정할 웹뷰
						 * @param contents
						 *            웹뷰가 표시할 컨텐츠
						 * @수정이력 1. ...
						 */
						public static void setWebViewContentsWithBaseURL(WebView webView, String contents) {
							try {
								webView.loadDataWithBaseURL("", contents, "text/html", "UTF-8", null);
							} catch (Exception e) {
								printDebugStackTrace(e);
							}
						}

						
					}
