package wu;

import com.tencent.avcore.jni.net.SocketInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a {
    void bindToNetInterface(SocketInfo socketInfo);

    int getCurManufacture();

    boolean hasFeature(int i3);

    boolean isSupportNetworkAcceleration();

    void notifyAPPStateToSys(int i3);

    void registerNetworkEventListener(zu.b bVar);

    void setAppBandwidth(int i3, int i16);

    void unBindToNetInterface(SocketInfo socketInfo);

    void unRegisterNetworkEventListener(zu.b bVar);
}
