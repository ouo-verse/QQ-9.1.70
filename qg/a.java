package qg;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.GuideButton;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends vg.a implements View.OnClickListener {
    private ImageView F;
    private QZoneUserAvatarView G;
    private QZoneUserAvatarView H;
    private QZoneUserAvatarView I;
    private QZoneUserAvatarView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private CellGuiding R;

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
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null && arrayList.size() >= 2) {
            String str = this.R.vecButton.get(1).actionUrl;
            QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "handleClickBtnGreet  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            gh.b.a(this.C, str, this.f441565h);
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "handleClickBtnGreet   vecButton.size() < 1");
    }

    private void J(View view) {
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null && arrayList.size() >= 1) {
            String str = this.R.vecButton.get(0).actionUrl;
            QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "handleClickBtnLeaveMessage  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b(view.getContext(), new g(str, null));
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "handleClickBtnLeaveMessage   vecButton.size() < 1");
    }

    private void K(View view) {
        Map<String, String> map;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
            String str = map.get("pic_action_url");
            QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "handleClickCardCover  actionUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.b(view.getContext(), new g(str, null));
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "handleClickCardCover  data error");
    }

    private void L() {
        ArrayList<User> arrayList;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (arrayList = cellGuiding.vecUsers) != null && arrayList.size() != 0) {
            this.G.setUser(this.R.vecUsers.get(0));
            if (this.R.vecUsers.size() > 1) {
                this.H.setUser(this.R.vecUsers.get(1));
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            if (this.R.vecUsers.size() > 2) {
                this.I.setUser(this.R.vecUsers.get(2));
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
            if (this.R.vecUsers.size() > 3) {
                this.J.setUser(this.R.vecUsers.get(3));
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator<User> it = this.R.vecUsers.iterator();
            while (it.hasNext()) {
                User next = it.next();
                sb5.append("{uin:");
                sb5.append(next.uin);
                sb5.append(",nick:");
                sb5.append(next.nickName);
                sb5.append("}");
            }
            QLog.i("QZoneFriendAnniversaryContentPresenter", 1, "updateAvatarList  userStr = " + sb5.toString());
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "updateAvatarList  user data is empty");
    }

    private void M() {
        ArrayList<GuideButton> arrayList;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (arrayList = cellGuiding.vecButton) != null) {
            if (arrayList.size() > 0) {
                this.Q.setText(this.R.vecButton.get(0).buttonTitle);
                QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "updateBtnData  messageTitle = " + this.R.vecButton.get(0).buttonTitle);
            }
            if (this.R.vecButton.size() > 1) {
                this.P.setText(this.R.vecButton.get(1).buttonTitle);
                QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "updateBtnData  GreetTitle = " + this.R.vecButton.get(1).buttonTitle);
                return;
            }
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "updateBtnData  data error");
    }

    private void N() {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (pictureItem = cellGuiding.pic) != null && (pictureUrl = pictureItem.currentUrl) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            Option obtain = Option.obtain();
            obtain.setUrl(this.R.pic.currentUrl.url);
            obtain.setTargetView(this.F);
            obtain.setNeedShowLoadingDrawable(false);
            if (this.F.getLayoutParams() != null) {
                obtain.setRequestWidth(this.F.getLayoutParams().width);
                obtain.setRequestHeight(this.F.getLayoutParams().height);
            }
            obtain.setLoadingDrawable(this.F.getResources().getDrawable(R.drawable.at8));
            obtain.setFailDrawable(this.F.getResources().getDrawable(R.drawable.at_));
            c.a().i(obtain, null);
            QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "updateCardCover  url = " + this.R.pic.currentUrl.url);
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "updateCardCover  url error");
    }

    private void O() {
        Map<String, String> map;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (map = cellGuiding.extendInfo) != null) {
            String str = map.get("since_day");
            this.N.setText(str);
            QLog.i("QZoneFriendAnniversaryContentPresenter", 1, "updateTimeData   sinceDay = " + str);
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "updateTimeData  data error");
    }

    private void P() {
        ArrayList<User> arrayList;
        CellGuiding cellGuiding = this.R;
        if (cellGuiding != null && (arrayList = cellGuiding.vecUsers) != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<User> it = this.R.vecUsers.iterator();
            while (it.hasNext()) {
                User next = it.next();
                if (!TextUtils.isEmpty(next.nickName) && !TextUtils.equals(String.valueOf(next.uin), LoginData.getInstance().getUinString())) {
                    arrayList2.add(next.nickName);
                }
            }
            QLog.d("QZoneFriendAnniversaryContentPresenter", 1, "updateTitleData  userNickList = " + arrayList2.toString());
            StringBuilder sb5 = new StringBuilder("\u4f60\u548c");
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (i3 > 0) {
                    sb5.append("\u3001");
                }
                sb5.append((String) arrayList2.get(i3));
            }
            this.K.setText(sb5.toString());
            this.L.setText("\u76f8\u8bc6");
            Map<String, String> map = this.R.extendInfo;
            if (map != null) {
                String str = map.get("know_years");
                this.M.setText(str);
                QLog.i("QZoneFriendAnniversaryContentPresenter", 1, "updateTitleData   knowYears = " + str);
                return;
            }
            return;
        }
        QLog.e("QZoneFriendAnniversaryContentPresenter", 1, "updateTitleData  user data is empty");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendAnniversaryContentPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f195560) {
            I(view);
        } else if (id5 == R.id.f195863) {
            J(view);
        } else if (id5 == R.id.kui) {
            K(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nok;
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
        this.R = businessFeedData.getCellGuiding();
        N();
        L();
        P();
        O();
        M();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (ImageView) view.findViewById(R.id.kui);
        this.G = (QZoneUserAvatarView) view.findViewById(R.id.nbz);
        this.H = (QZoneUserAvatarView) view.findViewById(R.id.f162920nc0);
        this.I = (QZoneUserAvatarView) view.findViewById(R.id.f162921nc1);
        this.J = (QZoneUserAvatarView) view.findViewById(R.id.f162922nc2);
        this.K = (TextView) view.findViewById(R.id.nko);
        this.L = (TextView) view.findViewById(R.id.nkl);
        this.M = (TextView) view.findViewById(R.id.nkm);
        this.N = (TextView) view.findViewById(R.id.nkb);
        this.P = (TextView) view.findViewById(R.id.f195560);
        this.Q = (TextView) view.findViewById(R.id.f195863);
        this.F.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        H();
    }
}
