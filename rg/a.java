package rg;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.l;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Map;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends vg.a implements View.OnClickListener {
    private ImageView F;
    private QZoneUserAvatarView G;
    private CellGuiding H;
    private TextView I;
    private TextView J;
    private TextView K;

    private void H() {
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int l3 = pl.a.f426446a.l(i());
        layoutParams.width = l3;
        layoutParams.height = (int) (l3 / 1.7777778f);
        this.F.setLayoutParams(layoutParams);
    }

    private void I(View view) {
        Map<String, String> map;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
            String str = map.get("pic_action_url");
            QLog.i("QZoneFriendBirthdayContentPresenter", 1, "handleClickCardCover  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b(view.getContext(), new g(str, null));
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "handleClickCardCover  data error");
    }

    private void J(View view) {
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null && arrayList.size() >= 2) {
            String str = this.H.vecButton.get(1).actionUrl;
            QLog.i("QZoneFriendBirthdayContentPresenter", 1, "handleClickGift  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b(view.getContext(), new g(str, null));
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "handleClickGift   vecButton.size() < 2");
    }

    private void K(View view) {
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null && arrayList.size() >= 1) {
            String str = this.H.vecButton.get(0).actionUrl;
            QLog.i("QZoneFriendBirthdayContentPresenter", 1, "handleClickLeaveMessage  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b(view.getContext(), new g(str, null));
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "handleClickLeaveMessage   vecButton.size() < 1");
    }

    private void L() {
        ArrayList<User> arrayList;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (arrayList = cellGuiding.vecUsers) != null && arrayList.size() != 0) {
            User user = this.H.vecUsers.get(0);
            this.G.setUser(user);
            QLog.i("QZoneFriendBirthdayContentPresenter", 1, "updateAvatarData  uin = " + user.uin + " , nick = " + user.nickName);
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "updateAvatarData  user data is empty");
    }

    private void M() {
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null) {
            if (arrayList.size() > 0) {
                this.K.setText(this.H.vecButton.get(0).buttonTitle);
                QLog.d("QZoneFriendBirthdayContentPresenter", 1, "updateBtnData  messageTitle = " + this.H.vecButton.get(0).buttonTitle);
            }
            if (this.H.vecButton.size() > 1) {
                this.J.setText(this.H.vecButton.get(1).buttonTitle);
                QLog.d("QZoneFriendBirthdayContentPresenter", 1, "updateBtnData  GreetTitle = " + this.H.vecButton.get(1).buttonTitle);
                return;
            }
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "updateBtnData  data error");
    }

    private void N() {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (pictureItem = cellGuiding.pic) != null && (pictureUrl = pictureItem.currentUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            Option obtain = Option.obtain();
            obtain.setUrl(this.H.pic.currentUrl.url);
            obtain.setTargetView(this.F);
            obtain.setNeedShowLoadingDrawable(false);
            if (this.F.getLayoutParams() != null) {
                obtain.setRequestWidth(this.F.getLayoutParams().width);
                obtain.setRequestHeight(this.F.getLayoutParams().height);
            }
            obtain.setLoadingDrawable(this.F.getResources().getDrawable(R.drawable.at8));
            obtain.setFailDrawable(this.F.getResources().getDrawable(R.drawable.at_));
            c.a().i(obtain, null);
            QLog.d("QZoneFriendBirthdayContentPresenter", 1, "updateCardCover  url = " + this.H.pic.currentUrl.url);
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "updateCardCover  url error");
    }

    private void O() {
        Map<String, String> map;
        CellGuiding cellGuiding = this.H;
        if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
            String str = map.get("title1");
            if (str == null) {
                str = "";
            }
            StringBuilder sb5 = new StringBuilder(str);
            ArrayList<User> arrayList = this.H.vecUsers;
            if (arrayList != null && arrayList.size() > 0) {
                sb5.append(this.H.vecUsers.get(0).nickName);
            }
            sb5.append(l.a(R.string.n9o));
            this.I.setText(sb5.toString());
            QLog.i("QZoneFriendBirthdayContentPresenter", 1, "updateTitleData   titleStr = " + sb5.toString());
            return;
        }
        QLog.e("QZoneFriendBirthdayContentPresenter", 1, "updateTitleData  data error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendBirthdayContentPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f19545z) {
            J(view);
        } else if (id5 == R.id.f195863) {
            K(view);
        } else if (id5 == R.id.kui) {
            I(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nom;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null) {
            return;
        }
        this.H = businessFeedData.getCellGuiding();
        N();
        L();
        O();
        M();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (ImageView) view.findViewById(R.id.kui);
        this.G = (QZoneUserAvatarView) view.findViewById(R.id.nby);
        this.I = (TextView) view.findViewById(R.id.nkk);
        this.K = (TextView) view.findViewById(R.id.f195863);
        this.J = (TextView) view.findViewById(R.id.f19545z);
        this.F.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.J.setOnClickListener(this);
        H();
    }
}
