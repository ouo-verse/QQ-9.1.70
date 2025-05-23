package yg2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h extends RecyclerView.ViewHolder {

    /* renamed from: d, reason: collision with root package name */
    private final ExtendFriendCampusVerifyTipsView f450295d;

    public h(View view, ExtendFriendCampusVerifyTipsView.a aVar) {
        super(view);
        ExtendFriendCampusVerifyTipsView extendFriendCampusVerifyTipsView = (ExtendFriendCampusVerifyTipsView) view;
        this.f450295d = extendFriendCampusVerifyTipsView;
        extendFriendCampusVerifyTipsView.setOnClickListener(aVar);
    }

    public void b(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, int i3) {
        if (bVar instanceof i) {
            this.f450295d.setTipsType(((i) bVar).f450296d);
            this.f450295d.setPadding(0, i3, 0, 0);
        }
    }
}
