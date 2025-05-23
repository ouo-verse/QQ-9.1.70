package w20;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.BaseDataCenter;
import com.tencent.richframework.data.idata.IDataConverter;
import e30.c;
import e40.j;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lb0.b;
import x20.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseDataCenter {

    /* renamed from: g, reason: collision with root package name */
    private static volatile a f444443g;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StFeed f444445b;

    /* renamed from: d, reason: collision with root package name */
    private long f444447d;

    /* renamed from: e, reason: collision with root package name */
    private long f444448e;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, MutableLiveData<c>> f444444a = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private String f444446c = "";

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<Integer, MutableLiveData<j>> f444449f = new HashMap<>();

    a() {
        addDataConverter(new x20.a());
        addDataConverter(new x20.c());
        addDataConverter(new d());
        addDataConverter(new b.C10716b());
        addDataConverter(new x20.b());
    }

    public static a j() {
        if (f444443g == null) {
            synchronized (a.class) {
                if (f444443g == null) {
                    f444443g = new a();
                }
            }
        }
        return f444443g;
    }

    public static void o() {
        if (f444443g != null) {
            synchronized (a.class) {
                if (f444443g != null) {
                    f444443g = new a();
                }
            }
        }
    }

    public void a() {
        this.f444448e = 0L;
    }

    public long b() {
        return this.f444447d;
    }

    public int c(String str) {
        return g(str).getValue().a();
    }

    public boolean d(String str) {
        return g(str).getValue().b();
    }

    public int e(String str) {
        return g(str).getValue().c();
    }

    public int f(String str) {
        return g(str).getValue().d();
    }

    public MutableLiveData<c> g(String str) {
        MutableLiveData<c> mutableLiveData = this.f444444a.get(str);
        if (mutableLiveData == null || mutableLiveData.getValue() == null) {
            MutableLiveData<c> mutableLiveData2 = new MutableLiveData<>();
            mutableLiveData2.setValue(new c(str));
            this.f444444a.put(str, mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    public String h() {
        return this.f444446c;
    }

    public FeedCloudMeta$StFeed i() {
        return this.f444445b;
    }

    public long k() {
        return this.f444448e;
    }

    public MutableLiveData<j> l(int i3) {
        MutableLiveData<j> mutableLiveData = this.f444449f.get(Integer.valueOf(i3));
        if (mutableLiveData == null) {
            MutableLiveData<j> mutableLiveData2 = new MutableLiveData<>();
            this.f444449f.put(Integer.valueOf(i3), mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    public void m() {
        this.f444448e = this.f444447d;
    }

    public void n(int i3, Observer<j> observer) {
        MutableLiveData<j> mutableLiveData;
        if (this.f444449f.containsKey(Integer.valueOf(i3))) {
            mutableLiveData = this.f444449f.get(Integer.valueOf(i3));
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        mutableLiveData.observeForever(observer);
        this.f444449f.put(Integer.valueOf(i3), mutableLiveData);
    }

    @Override // com.tencent.richframework.data.base.BaseDataCenter
    protected <S> void observerGlobalStateInner(IDataConverter<S> iDataConverter, MutableLiveData<S> mutableLiveData, S s16, Observer<S> observer) {
        super.observerGlobalStateInner(iDataConverter, mutableLiveData, s16, observer);
    }

    public void p(long j3) {
        this.f444447d = j3;
    }

    public void q(String str, int i3) {
        g(str).getValue().e(i3);
    }

    public void r(String str, boolean z16) {
        QLog.d("QCircleFeedDataCenter", 1, "setFeedAutoPlay " + z16);
        g(str).getValue().f(z16);
    }

    public void s(String str, int i3) {
        MutableLiveData<c> g16 = g(str);
        c value = g16.getValue();
        value.g(i3);
        g16.postValue(value);
    }

    public void t(String str, int i3) {
        MutableLiveData<c> g16 = g(str);
        c value = g16.getValue();
        value.h(i3);
        g16.postValue(value);
    }

    public void u(String str) {
        this.f444446c = str;
    }

    public void v(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f444445b = feedCloudMeta$StFeed;
    }

    public void w(int i3) {
        this.f444449f.remove(Integer.valueOf(i3));
    }

    public void x(int i3, Observer<j> observer) {
        MutableLiveData<j> l3 = l(i3);
        if (l3 != null) {
            l3.removeObserver(observer);
        }
    }
}
