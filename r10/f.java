package r10;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.l;
import com.tencent.biz.pubaccount.weishi.util.m;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lr10/f;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "LUserGrowth/stSimpleMetaComment;", "comment", "", "f", "data", "c", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "d", "Lcom/tencent/biz/pubaccount/weishi/richtext/FeedRichTextView;", "tvContent", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "e", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "setMFragment", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "mFragment", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "setMVerticalData", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;)V", "mVerticalData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "fragment", "verticalData", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends BaseViewHolder<stSimpleMetaComment> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FeedRichTextView tvContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WSVerticalPageFragment mFragment;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private j mVerticalData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"r10/f$a", "Lcom/tencent/biz/pubaccount/weishi/util/l;", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements l {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaComment f430483b;

        a(stSimpleMetaComment stsimplemetacomment) {
            this.f430483b = stsimplemetacomment;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.l
        public void a() {
            com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
            f.this.f(this.f430483b);
            WSVerticalPageFragment mFragment = f.this.getMFragment();
            Map<String, String> map = null;
            String from = mFragment != null ? mFragment.getFrom() : null;
            WSVerticalPageFragment mFragment2 = f.this.getMFragment();
            String playScene = mFragment2 != null ? mFragment2.getPlayScene() : null;
            j mVerticalData = f.this.getMVerticalData();
            stSimpleMetaFeed e16 = mVerticalData != null ? mVerticalData.e() : null;
            WSVerticalPageFragment mFragment3 = f.this.getMFragment();
            if (mFragment3 != null && (presenter = mFragment3.getPresenter()) != null) {
                map = presenter.h0();
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.X(from, playScene, e16, 1, map);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ViewGroup parent, WSVerticalPageFragment wSVerticalPageFragment, j jVar) {
        super(parent, R.layout.d18);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p75);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_comment_content)");
        FeedRichTextView feedRichTextView = (FeedRichTextView) findViewById;
        this.tvContent = feedRichTextView;
        this.mFragment = wSVerticalPageFragment;
        this.mVerticalData = jVar;
        feedRichTextView.setRichTextDisplayType(1);
        this.tvContent.setOnTouchListener(new m());
        this.tvContent.setBackgroundDrawable(ba.a(getContext().getResources().getColor(R.color.f7634s), ba.f81735j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(stSimpleMetaComment comment) {
        WSVerticalPageFragment wSVerticalPageFragment = this.mFragment;
        WsCommentPresenter wsCommentPresenter = wSVerticalPageFragment != null ? wSVerticalPageFragment.f81812c0 : null;
        if (wsCommentPresenter != null) {
            String l3 = com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(wSVerticalPageFragment != null ? wSVerticalPageFragment.getFrom() : null);
            WSVerticalPageFragment wSVerticalPageFragment2 = this.mFragment;
            wsCommentPresenter.m0(l3, wSVerticalPageFragment2 != null ? wSVerticalPageFragment2.getPlayScene() : null);
            wsCommentPresenter.v0(getPosition());
            wsCommentPresenter.t0(2);
            j jVar = this.mVerticalData;
            wsCommentPresenter.r0(jVar != null ? jVar.e() : null);
            wsCommentPresenter.p0(comment != null ? comment.f25128id : null);
            wsCommentPresenter.o0(true);
            wsCommentPresenter.w0();
        }
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void bindData(stSimpleMetaComment data) {
        stSimpleMetaPerson stsimplemetaperson;
        super.bindData(data);
        this.tvContent.setText(r.d((data == null || (stsimplemetaperson = data.poster) == null) ? null : stsimplemetaperson.nick, data != null ? data.wording : null, data != null ? data.poster_id : null, getContext().getResources().getColor(R.color.f77251), false, new a(data)));
    }

    /* renamed from: d, reason: from getter */
    public final WSVerticalPageFragment getMFragment() {
        return this.mFragment;
    }

    /* renamed from: e, reason: from getter */
    public final j getMVerticalData() {
        return this.mVerticalData;
    }
}
