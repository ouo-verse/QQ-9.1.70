package t10;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r10.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lt10/b;", "", "", "isFirst", "isRefresh", "", "b", "Lt10/a;", "a", "Lt10/a;", "mView", "Lr10/d;", "Lr10/d;", "mDataFetcher", "view", "<init>", "(Lt10/a;)V", "c", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a mView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d mDataFetcher;

    public b(a view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mView = view;
        this.mDataFetcher = new d();
    }

    public void b(boolean isFirst, boolean isRefresh) {
        stSimpleMetaFeed e16;
        j itemData = this.mView.getItemData();
        String str = (itemData == null || (e16 = itemData.e()) == null) ? null : e16.f25129id;
        if (str == null) {
            return;
        }
        this.mDataFetcher.d(new s10.b(isFirst, isRefresh, str), new C11268b(isFirst, this));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"t10/b$b", "Lkz/a;", "Ls10/a;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t10.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11268b implements kz.a<s10.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f435292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f435293b;

        C11268b(boolean z16, b bVar) {
            this.f435292a = z16;
            this.f435293b = bVar;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(s10.a data) {
            stSimpleMetaFeed e16;
            Intrinsics.checkNotNullParameter(data, "data");
            List<stSimpleMetaComment> a16 = data.a();
            if (!this.f435292a || a16.size() >= 1) {
                j itemData = this.f435293b.mView.getItemData();
                String str = (itemData == null || (e16 = itemData.e()) == null) ? null : e16.f25129id;
                if (!(true ^ a16.isEmpty()) || TextUtils.equals(str, a16.get(0).feedId)) {
                    this.f435293b.mView.a(data.a(), this.f435292a, data.getIsFinished());
                }
            }
        }

        @Override // kz.a
        public void onFailure(int errorCode, String errorMsg) {
        }
    }
}
