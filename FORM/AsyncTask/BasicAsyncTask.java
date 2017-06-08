	package com.BeezPlanet.bpline.common.task;
	
	import com.BeezPlanet.bpline.common.restful.RestfulBPLineDataProvider;
import com.BeezPlanet.bpline.common.utils.CommonUtils;

import android.os.AsyncTask;
	
	/**
	 * 기본적인 ASYNC 태스크
	 * @author Administrator
	 * @param <T>
	 *
	 */
	public class BasicAsyncTask extends AsyncTask<Integer, Integer, T> {
	
		private AsyncTaskCallback<?> mCallback;
		
		public BasicAsyncTask(AsyncTaskCallback<?> callback) {
	
			this.mCallback = callback;
		
		}
		
		@Override
		protected T doInBackground(Integer... params) {
			
			try {
				
				int type = params[0];
				
				int stationCityId = params[1];
				
				int stationId = params[2];
				
				return RestfulBPLineDataProvider.getEventList(type, stationCityId, stationId);
			
			} catch (Exception e) {
				
				CommonUtils.printDebugStackTrace(e);
				
			}
			
			return null;
		}
	
		@Override
		protected void onPostExecute(T result)
		{
			try {
				
				if(mCallback != null)
					
					mCallback.postExecute(result);
				
				super.onPostExecute(result);
				
			} catch (Exception e) {
				
				CommonUtils.printDebugStackTrace(e);
				
			}
		}
	}
