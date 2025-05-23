package tt1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.PreFilterMsgOp;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.PullMsgOp;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.SummarizeMsgOp;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f437448a;

    /* renamed from: b, reason: collision with root package name */
    private final String f437449b;

    /* renamed from: c, reason: collision with root package name */
    private final String f437450c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Long> f437451d;

    /* renamed from: e, reason: collision with root package name */
    private List<Long> f437452e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, MessageRecord> f437453f;

    /* renamed from: g, reason: collision with root package name */
    private PreFilterMsgOp f437454g;

    /* renamed from: h, reason: collision with root package name */
    private PullMsgOp f437455h;

    /* renamed from: i, reason: collision with root package name */
    private SummarizeMsgOp f437456i;

    /* compiled from: P */
    /* renamed from: tt1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C11308a extends a.AbstractC7847a {
        C11308a() {
        }

        @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a.AbstractC7847a
        public void a(a.b bVar) {
            a.this.e(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends a.AbstractC7847a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a.AbstractC7847a
        public void a(a.b bVar) {
            a.this.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends a.AbstractC7847a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a.AbstractC7847a
        public void a(a.b bVar) {
            a.this.g(bVar);
        }
    }

    public a(AppRuntime appRuntime, String str, String str2, List<Long> list, st1.a aVar) {
        this.f437448a = appRuntime;
        this.f437449b = str;
        this.f437450c = str2;
        this.f437451d = list;
        this.f437452e = list;
        this.f437453f = new ConcurrentHashMap<>(list.size());
    }

    private void d(a.b bVar) {
        ArrayList arrayList = new ArrayList();
        for (Long l3 : this.f437451d) {
            if (this.f437453f.containsKey(l3)) {
                arrayList.add(this.f437453f.get(l3));
            }
        }
        com.tencent.mobileqq.guild.message.c cVar = new com.tencent.mobileqq.guild.message.c();
        cVar.d(this.f437449b);
        cVar.b(bVar.a());
        cVar.c(bVar.b());
        cVar.a(this.f437450c);
        cVar.e(arrayList);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(a.b bVar) {
        List<Long> j3 = this.f437454g.j();
        this.f437452e = j3;
        if (j3.isEmpty()) {
            QLog.i("GetDisRoamMsgTask", 1, "doPreFilterMsgResult do not need pull , doCallback channelId = " + this.f437450c + " size = " + k());
            d(bVar);
            return;
        }
        QLog.i("GetDisRoamMsgTask", 1, "doPreFilterMsgResult need pull channelId = " + this.f437450c + " mNeedPullMsgSeqList size = " + this.f437452e.size() + " size = " + k());
        PullMsgOp pullMsgOp = new PullMsgOp(this.f437448a, this, this.f437452e, new b());
        this.f437455h = pullMsgOp;
        pullMsgOp.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(a.b bVar) {
        if (bVar.a() != 1000) {
            QLog.i("GetDisRoamMsgTask", 1, "doPullMsgResult error ! channelId = " + this.f437450c + " mNeedPullMsgSeqList size = " + this.f437452e.size() + " size = " + k() + "errorCode = " + bVar.a() + " errorMsg = " + bVar.b());
            d(bVar);
            return;
        }
        QLog.i("GetDisRoamMsgTask", 1, "doPullMsgResult ok ! channelId = " + this.f437450c + " mNeedPullMsgSeqList size = " + this.f437452e.size() + " size = " + k());
        SummarizeMsgOp summarizeMsgOp = new SummarizeMsgOp(this.f437448a, this, this.f437452e, new c());
        this.f437456i = summarizeMsgOp;
        summarizeMsgOp.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(a.b bVar) {
        QLog.i("GetDisRoamMsgTask", 1, "doSummarizeMsgResult channelId = " + this.f437450c + " mNeedPullMsgSeqList size = " + this.f437452e.size() + " size = " + k());
        d(bVar);
    }

    public String h() {
        return this.f437450c;
    }

    public String i() {
        return this.f437449b;
    }

    public List<Long> j() {
        return this.f437451d;
    }

    public ConcurrentHashMap<Long, MessageRecord> k() {
        return this.f437453f;
    }

    public void l() {
        PreFilterMsgOp preFilterMsgOp = new PreFilterMsgOp(this.f437448a, this, new C11308a());
        this.f437454g = preFilterMsgOp;
        preFilterMsgOp.e();
    }
}
