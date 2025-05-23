package u4;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryActivity;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity;
import com.qzone.common.event.EventCenter;
import com.qzone.misc.network.report.ClickReport;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends c {
    @Override // u4.c
    public void A(Activity activity, int i3) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).u().setVisibility(i3);
        }
    }

    @Override // u4.c
    public void B(Activity activity, String str) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).setTitle(str);
        }
    }

    @Override // u4.c
    public void C(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).t();
        } else if (activity instanceof QzonePhotoCategoryActivity) {
            ((QzonePhotoCategoryActivity) activity).t();
        }
    }

    @Override // u4.c
    public Intent b(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).getIntent();
        }
        if (activity instanceof QzonePhotoCategoryActivity) {
            return ((QzonePhotoCategoryActivity) activity).getIntent();
        }
        return null;
    }

    @Override // u4.c
    public int c(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).x().getPaddingBottom();
        }
        return 0;
    }

    @Override // u4.c
    public int d(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).x().getPaddingLeft();
        }
        return 0;
    }

    @Override // u4.c
    public int e(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).x().getPaddingRight();
        }
        return 0;
    }

    @Override // u4.c
    public int f(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).x().getPaddingTop();
        }
        return 0;
    }

    @Override // u4.c
    public String g(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).getTextTitle();
        }
        return null;
    }

    @Override // u4.c
    public void h(Activity activity, int i3, int i16) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("extra_choose_friend", 6);
        intent.putExtra("key_selected_share_uin", i3);
        intent.putExtra("only_single_selection", true);
        activity.startActivityForResult(intent, i16);
    }

    @Override // u4.c
    public void i(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).y();
        } else if (activity instanceof QzonePhotoCategoryActivity) {
            ((QzonePhotoCategoryActivity) activity).y();
        }
    }

    @Override // u4.c
    public boolean k(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            return ((QzonePhotoCategoryDetailsActivity) activity).D3();
        }
        return false;
    }

    @Override // u4.c
    public void l(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).E3();
        }
    }

    @Override // u4.c
    public void m(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).t3();
        }
    }

    @Override // u4.c
    public void n(Activity activity) {
        if (activity instanceof QzonePhotoCategoryActivity) {
            EventCenter.getInstance().addUIObserver((QzonePhotoCategoryActivity) activity, "QzoneAlbum", 16);
        }
    }

    @Override // u4.c
    public void o(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            QzonePhotoCategoryDetailsActivity qzonePhotoCategoryDetailsActivity = (QzonePhotoCategoryDetailsActivity) activity;
            EventCenter.getInstance().addUIObserver(qzonePhotoCategoryDetailsActivity, "QzoneAlbum", 11, 15, 9, 24);
            EventCenter.getInstance().addUIObserver(qzonePhotoCategoryDetailsActivity, "WriteOperation", 7, 48);
        }
    }

    @Override // u4.c
    public void p(Activity activity) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            EventCenter.getInstance().removeObserver((QzonePhotoCategoryDetailsActivity) activity);
        }
    }

    @Override // u4.c
    public void q(Activity activity) {
        if (activity instanceof QzonePhotoCategoryActivity) {
            EventCenter.getInstance().removeObserver((QzonePhotoCategoryActivity) activity);
        }
    }

    @Override // u4.c
    public void s(Activity activity, View.OnClickListener onClickListener) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).F3(onClickListener);
        }
    }

    @Override // u4.c
    public void t(Activity activity, String str) {
        QzonePhotoCategoryDetailsActivity qzonePhotoCategoryDetailsActivity = (QzonePhotoCategoryDetailsActivity) activity;
        if (qzonePhotoCategoryDetailsActivity.C3() != null) {
            qzonePhotoCategoryDetailsActivity.C3().setContentDescription(str);
        }
    }

    @Override // u4.c
    public void u(Activity activity, int i3) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).G3(i3);
        }
    }

    @Override // u4.c
    public void v(Activity activity, int i3) {
        QzonePhotoCategoryDetailsActivity qzonePhotoCategoryDetailsActivity = (QzonePhotoCategoryDetailsActivity) activity;
        if (qzonePhotoCategoryDetailsActivity.C3() != null) {
            qzonePhotoCategoryDetailsActivity.C3().setVisibility(i3);
        }
    }

    @Override // u4.c
    public void w(Activity activity, int i3) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).x().setBackgroundResource(i3);
        }
    }

    @Override // u4.c
    public void x(Activity activity, View.OnClickListener onClickListener) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).x().setOnClickListener(onClickListener);
        }
    }

    @Override // u4.c
    public void y(Activity activity, int i3, int i16, int i17, int i18) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).x().setPadding(i3, i16, i17, i18);
        }
    }

    @Override // u4.c
    public void z(Activity activity, String str) {
        if (activity instanceof QzonePhotoCategoryDetailsActivity) {
            ((QzonePhotoCategoryDetailsActivity) activity).x().setText(str);
        }
    }

    @Override // u4.c
    public void r(String str, String str2, String str3) {
        ClickReport.p(str, str2, str3, null, true);
    }
}
