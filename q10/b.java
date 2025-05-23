package q10;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  *\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004\u0007\b\t\u0018B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0014\u0010\t\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J2\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R&\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lq10/b;", "T", "Ljz/c;", "listener", "Lq10/b$c;", "response", "", "a", "b", "c", "", VideoTemplateParser.ITEM_LIST, "", "isRefresh", "isFirst", "", "extObject", "d0", "", "errorCode", "", "errorMsg", "i", "Ljava/lang/ref/SoftReference;", "d", "Ljava/lang/ref/SoftReference;", "tempListener", "e", "Lq10/b$c;", "tempRsp", "<init>", "()V", "f", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b<T> implements jz.c<T> {

    /* renamed from: f, reason: collision with root package name */
    private static final a f428183f = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SoftReference<jz.c<T>> tempListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c<T> tempRsp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lq10/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lq10/b$b;", "", "", "a", "I", "()I", "errorCode", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "", "c", "Z", "()Z", "isFirst", "d", "isRefresh", "<init>", "(ILjava/lang/String;ZZ)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: q10.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11052b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int errorCode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String errorMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isFirst;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isRefresh;

        public C11052b(int i3, String str, boolean z16, boolean z17) {
            this.errorCode = i3;
            this.errorMsg = str;
            this.isFirst = z16;
            this.isRefresh = z17;
        }

        /* renamed from: a, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: b, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsFirst() {
            return this.isFirst;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsRefresh() {
            return this.isRefresh;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0004\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lq10/b$c;", "T", "", "", "a", "Z", "c", "()Z", "e", "(Z)V", "isSuccess", "Lq10/b$d;", "b", "Lq10/b$d;", "()Lq10/b$d;", "f", "(Lq10/b$d;)V", "successRsp", "Lq10/b$b;", "Lq10/b$b;", "()Lq10/b$b;", "d", "(Lq10/b$b;)V", "failedRsp", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private d<T> successRsp;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private C11052b failedRsp;

        /* renamed from: a, reason: from getter */
        public final C11052b getFailedRsp() {
            return this.failedRsp;
        }

        public final d<T> b() {
            return this.successRsp;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public final void d(C11052b c11052b) {
            this.failedRsp = c11052b;
        }

        public final void e(boolean z16) {
            this.isSuccess = z16;
        }

        public final void f(d<T> dVar) {
            this.successRsp = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B1\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lq10/b$d;", "T", "", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "", "Z", "d", "()Z", "isRefresh", "c", "isFirst", "Ljava/lang/Object;", "()Ljava/lang/Object;", "extObject", "<init>", "(Ljava/util/List;ZZLjava/lang/Object;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class d<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<T> itemList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isRefresh;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isFirst;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Object extObject;

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends T> list, boolean z16, boolean z17, Object obj) {
            this.itemList = list;
            this.isRefresh = z16;
            this.isFirst = z17;
            this.extObject = obj;
        }

        /* renamed from: a, reason: from getter */
        public final Object getExtObject() {
            return this.extObject;
        }

        public final List<T> b() {
            return this.itemList;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsFirst() {
            return this.isFirst;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsRefresh() {
            return this.isRefresh;
        }
    }

    public final void c(jz.c<T> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        x.f("WSRequestListenerMediator", "registerListener()");
        this.tempListener = new SoftReference<>(listener);
        a(listener, this.tempRsp);
    }

    @Override // jz.c
    public void d0(List<? extends T> itemList, boolean isRefresh, boolean isFirst, Object extObject) {
        x.f("WSRequestListenerMediator", "onSuccess()");
        c<T> cVar = new c<>();
        cVar.e(true);
        cVar.f(new d<>(itemList, isRefresh, isFirst, extObject));
        this.tempRsp = cVar;
        SoftReference<jz.c<T>> softReference = this.tempListener;
        a(softReference != null ? softReference.get() : null, this.tempRsp);
    }

    @Override // jz.c
    public void i(int errorCode, String errorMsg, boolean isFirst, boolean isRefresh) {
        x.f("WSRequestListenerMediator", "onFailed()");
        c<T> cVar = new c<>();
        cVar.e(false);
        cVar.d(new C11052b(errorCode, errorMsg, isFirst, isRefresh));
        this.tempRsp = cVar;
        SoftReference<jz.c<T>> softReference = this.tempListener;
        a(softReference != null ? softReference.get() : null, this.tempRsp);
    }

    private final void b() {
        this.tempRsp = null;
        this.tempListener = null;
    }

    private final void a(jz.c<T> listener, c<T> response) {
        if (listener != null && response != null) {
            if (response.getIsSuccess()) {
                d<T> b16 = response.b();
                Intrinsics.checkNotNull(b16);
                listener.d0(b16.b(), b16.getIsRefresh(), b16.getIsFirst(), b16.getExtObject());
            } else {
                C11052b failedRsp = response.getFailedRsp();
                Intrinsics.checkNotNull(failedRsp);
                listener.i(failedRsp.getErrorCode(), failedRsp.getErrorMsg(), failedRsp.getIsFirst(), failedRsp.getIsRefresh());
            }
            b();
            return;
        }
        x.f("WSRequestListenerMediator", "checkIfCallbackResponse() param is null. listener = " + listener + ", response = " + response);
    }
}
