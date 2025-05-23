package yg2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.vip.widget.VipGeneralGdtShowView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    public ExtendFriendFeedView f450259d;

    /* renamed from: e, reason: collision with root package name */
    public VipGeneralGdtShowView f450260e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.qqexpand.fragment.f f450261f;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements VipGeneralGdtShowView.c {
        a() {
        }

        @Override // cooperation.vip.widget.VipGeneralGdtShowView.c
        public void a() {
            b bVar = b.this;
            com.tencent.mobileqq.qqexpand.fragment.f fVar = bVar.f450261f;
            if (fVar != null) {
                fVar.X6(bVar.getPosition());
            }
        }
    }

    public b(View view, Context context, com.tencent.mobileqq.qqexpand.fragment.f fVar, VipGeneralGdtShowView vipGeneralGdtShowView) {
        super(view);
        this.f450259d = (ExtendFriendFeedView) view;
        this.f450260e = vipGeneralGdtShowView;
        this.f450261f = fVar;
        if (vipGeneralGdtShowView != null) {
            vipGeneralGdtShowView.h(vipGeneralGdtShowView.g(), new a());
        }
    }

    public void b(b bVar, com.tencent.mobileqq.qqexpand.bean.feed.b bVar2, int i3) {
        AlumBasicData alumBasicData;
        if (this.f450259d != null && bVar2 != null) {
            bVar.f450259d.setFeedBgParams(bVar.getPosition(), bVar2.mVoiceUrl, i3, false);
        }
        if (this.f450260e == null || bVar2 == null || (alumBasicData = bVar2.mAlumbasicdata) == null) {
            return;
        }
        bVar.f450260e.l(alumBasicData, bVar.getAdapterPosition());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
