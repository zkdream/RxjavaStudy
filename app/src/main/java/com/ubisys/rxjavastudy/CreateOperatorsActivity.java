package com.ubisys.rxjavastudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CreateOperatorsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_operators);
    }

    public void fromArrayOperator(View view){
        Integer[] items = { 0, 1, 2, 3, 4 };
        Observable.fromArray(items).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("sss", "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("sss", "接收到了事件"+ integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss", "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e("sss", "对Complete事件作出响应");
            }
        });
    }

    public void fromIterableOperator(View view){
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Observable.fromIterable(list).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("sss", "开始采用subscribe连接");
            }

            @Override
            public void onNext(String s) {
                Log.e("sss", "接收到了事件"+ s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss", "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e("sss", "对Complete事件作出响应");
            }
        });
    }

    public void emptyOperator(View view){
        Observable.empty()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("sss", "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e("sss", "接收到了事件"+ o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sss", "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("sss", "对Complete事件作出响应");
                    }
                });
    }
    Integer i=6;
    public void deferOperator(View view){

        Observable<Integer> observable=Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                return Observable.just(i);
            }
        });
        i=8;
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("sss", "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("sss", "接收到了事件"+ integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss", "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e("sss", "对Complete事件作出响应");
            }
        });


    }

    public void timerOperator(View view){
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("sss", "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("sss", "接收到了事件"+ aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sss", "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("sss", "对Complete事件作出响应");
                    }
                });
    }

    public void intervalOperator(View view){
        Observable.interval(5,2,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("sss", "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("sss", "接收到了事件"+ aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sss", "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("sss", "对Complete事件作出响应");
                    }
                });

    }
    public void intervalRangeOperator(View view){
        // 参数1 = 事件序列起始点；
        // 参数2 = 事件数量；
        // 参数3 = 第1次事件延迟发送时间；
        // 参数4 = 每个间隔时间；
        // 参数5 = 时间单位
        Observable.intervalRange(6,10,5,2,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("sss", "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e("sss", "接收到了事件"+ aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sss", "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("sss", "对Complete事件作出响应");
                    }
                });
    }

    public void range(View view){
        // 参数1 事件序列起始点
        // 参数2 事件数量
        Observable.range(6,10).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("sss", "开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e("sss", "接收到了事件"+ integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss", "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e("sss", "对Complete事件作出响应");
            }
        });

    }
    public void rangeLong(View view){
        // 参数1 事件序列起始点
        // 参数2 事件数量
        Observable.rangeLong(6,10).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("sss", "开始采用subscribe连接");
            }

            @Override
            public void onNext(Long along) {
                Log.e("sss", "接收到了事件"+ along);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("sss", "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e("sss", "对Complete事件作出响应");
            }
        });

    }

}
