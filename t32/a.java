package t32;

import bz0.c;
import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.data.config.MessagePushConfig;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a extends IQQLiveModule {
    b b();

    SharedFlow<c> d(int i3);

    long getRoomId();

    void h(long j3, long j16);

    void registerMessageSmoothConfig(MessagePushConfig messagePushConfig);

    void unRegisterMessageSmooth();
}
