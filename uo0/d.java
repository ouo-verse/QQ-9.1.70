package uo0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.quickAt.search.SearchCategoryChannelInfoList;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wh2.br;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends k {

    /* renamed from: c, reason: collision with root package name */
    private final AppRuntime f439315c;

    /* renamed from: d, reason: collision with root package name */
    private final String f439316d;

    /* renamed from: e, reason: collision with root package name */
    private final String f439317e;

    /* renamed from: f, reason: collision with root package name */
    private List<IGProCategoryChannelInfoList> f439318f;

    /* renamed from: g, reason: collision with root package name */
    private IGProChannel f439319g;

    public d(@NonNull AppRuntime appRuntime, @NonNull String str, @NonNull String str2) {
        this.f439315c = appRuntime;
        this.f439316d = str;
        this.f439317e = str2;
    }

    private ArrayList<IGProChannel> p(List<IGProChannel> list) {
        ArrayList<IGProChannel> arrayList = new ArrayList<>();
        for (IGProChannel iGProChannel : list) {
            if (s(iGProChannel.getChannelName())) {
                arrayList.add(iGProChannel);
            }
        }
        return arrayList;
    }

    public static int[] r(String str, String str2) {
        int[] iArr = {-1, 0, 0};
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            int indexOf = str2.toLowerCase().indexOf(lowerCase);
            iArr[0] = indexOf;
            if (indexOf != -1) {
                iArr[1] = lowerCase.length();
                iArr[2] = 3;
            }
        }
        return iArr;
    }

    private boolean s(String str) {
        if (TextUtils.isEmpty(this.f439317e)) {
            return true;
        }
        int[] r16 = r(this.f439317e, str);
        if (r16.length >= 3 && r16[0] > -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ArrayList arrayList) {
        String categoryName;
        this.f439318f = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) it.next();
                boolean z16 = true;
                if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
                    if (((IGuildUserService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGuildUserService.class, "")).guildMode() != GuildMsgAbFlag.KSIMPLEMODEL) {
                        z16 = false;
                    }
                    if (z16) {
                        categoryName = "\u70ed\u95e8";
                    } else {
                        categoryName = iGProCategoryChannelInfoList.getCategoryName();
                    }
                    u(iGProCategoryChannelInfoList, s(categoryName));
                } else if (iGProCategoryChannelInfoList.getCategoryType() == 0 || iGProCategoryChannelInfoList.getCategoryType() == 2 || iGProCategoryChannelInfoList.getCategoryType() == 3 || iGProCategoryChannelInfoList.getCategoryType() == 9) {
                    v(iGProCategoryChannelInfoList);
                    ArrayList<IGProChannel> p16 = p(iGProCategoryChannelInfoList.getChannelInfoList());
                    if (!p16.isEmpty()) {
                        this.f439318f.add(new SearchCategoryChannelInfoList(iGProCategoryChannelInfoList.getCategoryName(), iGProCategoryChannelInfoList.getCategoryId(), 0, p16));
                    }
                }
            }
        }
        d();
    }

    private void u(IGProCategoryChannelInfoList iGProCategoryChannelInfoList, boolean z16) {
        if (z16) {
            this.f439318f.add(new SearchCategoryChannelInfoList(iGProCategoryChannelInfoList.getCategoryName(), iGProCategoryChannelInfoList.getCategoryId(), iGProCategoryChannelInfoList.getCategoryType(), iGProCategoryChannelInfoList.getChannelInfoList()));
            return;
        }
        ArrayList<IGProChannel> p16 = p(iGProCategoryChannelInfoList.getChannelInfoList());
        if (!p16.isEmpty()) {
            this.f439318f.add(new SearchCategoryChannelInfoList(iGProCategoryChannelInfoList.getCategoryName(), iGProCategoryChannelInfoList.getCategoryId(), iGProCategoryChannelInfoList.getCategoryType(), p16));
        }
    }

    private void v(IGProCategoryChannelInfoList iGProCategoryChannelInfoList) {
        ArrayList<IGProChannel> channelInfoList;
        if (this.f439319g == null && iGProCategoryChannelInfoList.getCategoryType() == 0 && (channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList()) != null) {
            Iterator<IGProChannel> it = channelInfoList.iterator();
            while (it.hasNext()) {
                IGProChannel next = it.next();
                if (next.getHiddenPostChannel() == 1 && next.getChannelType() == 7) {
                    QLog.i("GuildChannelSearch", 1, "setFeedSquareChannelInfo, id: " + next.getChannelId());
                    this.f439319g = next;
                }
            }
        }
    }

    @Override // uo0.k
    public String f() {
        return this.f439316d + ":" + this.f439317e;
    }

    @Override // uo0.k
    public String h() {
        return this.f439317e;
    }

    @Override // uo0.k
    public List<IGProCategoryChannelInfoList> i() {
        return this.f439318f;
    }

    @Override // uo0.k
    public void m() {
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(this.f439316d));
        bdVar.l(true);
        ((IGPSService) this.f439315c.getRuntimeService(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, new br() { // from class: uo0.c
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                d.this.t(arrayList);
            }
        });
    }

    public IGProChannel q() {
        return this.f439319g;
    }
}
