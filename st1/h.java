package st1;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface h {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f434699a;

        /* renamed from: b, reason: collision with root package name */
        public String f434700b;

        /* renamed from: c, reason: collision with root package name */
        public String f434701c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<AtTroopMemberInfo> f434702d;

        /* renamed from: f, reason: collision with root package name */
        public long f434704f;

        /* renamed from: h, reason: collision with root package name */
        public boolean f434706h;

        /* renamed from: i, reason: collision with root package name */
        public byte f434707i;

        /* renamed from: j, reason: collision with root package name */
        public int f434708j;

        /* renamed from: k, reason: collision with root package name */
        public int f434709k;

        /* renamed from: e, reason: collision with root package name */
        public boolean f434703e = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f434705g = false;
    }

    void C2();

    void O1(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16);

    long h0(AppInterface appInterface, a aVar);

    long j0(AppInterface appInterface, a aVar);

    List<MessageRecord> n2();

    void q(String str, long j3, long j16);
}
