package com.ubisys.rxjavastudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.schedulers.IoScheduler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void SimpleRxJava(View view){
        Observable observable=Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        Observer observer=new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Object o) {
                Log.e("sss","接受到"+o+"事件");
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
                Log.e("sss","接受事件完成");
            }
        };

        observable.subscribe(observer);
    }

    public void SimpleChainRxJava(View view){
        Observable.just("1","2","3").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("sss", "接受到" + s + "事件");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("sss", "接受事件异常");
            }
        });
    }

    public void CreateOperators(View view){
        startActivity(new Intent(this,CreateOperatorsActivity.class));
    }
}
