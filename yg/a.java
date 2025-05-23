package yg;

import android.util.Base64;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.cardcontainer.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aR$\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lyg/a;", "Lcom/tencent/mobileqq/cardcontainer/g;", "", "toUin", "T1", "uin", "reason", "algoId", "S1", "nick", "R1", "W1", "U1", "", "fromCache", "", "P1", "O1", "", "position", "M1", ZPlanPublishSource.FROM_SCHEME, "N1", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "X1", "", "mayKnowList", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Q1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "getBusinessFeedData", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "setBusinessFeedData", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", "businessFeedData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends g {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData businessFeedData;

    private final String R1(String uin, String nick, String algoId) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TuxUIConstants.POP_BTN_TEXT, "\u52a0\u597d\u53cb");
            jSONObject.put("uin", uin);
            jSONObject.put("btnScheme", U1(uin, nick, algoId));
        } catch (Exception e16) {
            QLog.e("PYMKCardContainerQZoneVM", 1, "createCardItemExtData error: " + e16.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final String S1(String uin, String reason, String algoId) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rcmd_uin", uin);
            jSONObject.put("itemId", T1(uin));
            jSONObject.put("alghrithm", algoId);
            jSONObject.put("sourceID", 3045);
            jSONObject.put("subSourceID", 69);
            jSONObject.put("recommend_reason", reason);
        } catch (Exception e16) {
            QLog.e("PYMKCardContainerQZoneVM", 1, "createCardItemReportData error: " + e16.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final String T1(String toUin) {
        String str;
        if (MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() != null) {
            str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        } else {
            str = "null";
        }
        return str + "_" + toUin;
    }

    private final String U1(String uin, String nick, String algoId) {
        String str = "mqqapi://relation/addFriend?addFriendVCType=1&sourceID=3045&subSourceID=69&uin=" + uin + "&addfriend_nick=" + nick;
        try {
            byte[] bytes = algoId.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return str + "&alghrithm=" + Base64.encodeToString(bytes, 0);
        } catch (AssertionError unused) {
            QLog.e("PYMKCardContainerQZoneVM", 1, "algoId encode error " + uin + " " + algoId);
            return str;
        }
    }

    private final String W1(String uin, String reason, String algoId) {
        String str = "mqqapi://card/show_pslcard?src_type=internal&blockSplit=1&source=sharecard&version=1&addfriend_sourceid=3045&addfriend_subsourceid=69&uin=" + uin;
        try {
            byte[] bytes = algoId.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            str = str + "&alghrithm=" + Base64.encodeToString(bytes, 0);
        } catch (AssertionError unused) {
            QLog.e("PYMKCardContainerQZoneVM", 1, "algoId encode error " + uin + " " + algoId);
        }
        try {
            byte[] bytes2 = reason.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            return str + "&reason=" + Base64.encodeToString(bytes2, 0);
        } catch (AssertionError unused2) {
            QLog.e("PYMKCardContainerQZoneVM", 1, "reason encode error " + uin + " " + reason);
            return str;
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void M1(int position) {
        User user;
        User user2;
        CellOperationInfo operationInfoV2;
        BusinessFeedData businessFeedData = this.businessFeedData;
        if (businessFeedData == null) {
            return;
        }
        Long l3 = null;
        if ((businessFeedData != null ? businessFeedData.getOperationInfoV2() : null) == null) {
            return;
        }
        BusinessFeedData businessFeedData2 = this.businessFeedData;
        if (((businessFeedData2 == null || (operationInfoV2 = businessFeedData2.getOperationInfoV2()) == null) ? null : operationInfoV2.busiParam) == null) {
            return;
        }
        BusinessFeedData businessFeedData3 = this.businessFeedData;
        Intrinsics.checkNotNull(businessFeedData3);
        String str = businessFeedData3.getOperationInfoV2().busiParam.get(92);
        BusinessFeedData businessFeedData4 = this.businessFeedData;
        Intrinsics.checkNotNull(businessFeedData4);
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData4.getRecBusinessFeedDatas();
        Intrinsics.checkNotNullExpressionValue(recBusinessFeedDatas, "businessFeedData!!.getRecBusinessFeedDatas()");
        if (recBusinessFeedDatas.isEmpty() || recBusinessFeedDatas.size() < position + 1) {
            return;
        }
        BusinessFeedData businessFeedData5 = recBusinessFeedDatas.get(position);
        Intrinsics.checkNotNullExpressionValue(businessFeedData5, "data[position]");
        BusinessFeedData businessFeedData6 = businessFeedData5;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(businessFeedData6.getOperationInfoV2().busiParam.get(52));
        com.qzone.feed.business.model.c.d().f(4, str, arrayList, 9);
        CellRecommItem recommItem = businessFeedData6.getRecommItem();
        if (recommItem != null && (user2 = recommItem.userInfo) != null) {
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeRecommendData(String.valueOf(user2.uin));
        }
        CellRecommItem recommItem2 = businessFeedData6.getRecommItem();
        if (recommItem2 != null && (user = recommItem2.userInfo) != null) {
            l3 = Long.valueOf(user.uin);
        }
        QLog.i("PYMKCardContainerQZoneVM", 1, "onCloseCard uin:" + l3);
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void N1(int position, String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        QLog.i("PYMKCardContainerQZoneVM", 1, "onJumpAction position:" + position + " scheme:" + scheme);
    }

    public final void X1(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        this.businessFeedData = feedData;
        Intrinsics.checkNotNull(feedData);
        ArrayList<BusinessFeedData> recBusinessFeedDatas = feedData.getRecBusinessFeedDatas();
        Intrinsics.checkNotNullExpressionValue(recBusinessFeedDatas, "businessFeedData!!.getRecBusinessFeedDatas()");
        List<com.tencent.mobileqq.cardcontainer.data.a> Q1 = Q1(recBusinessFeedDatas);
        L1().setValue(Q1);
        QLog.i("PYMKCardContainerQZoneVM", 1, "updateQZonePYMKData size:" + Q1.size());
    }

    public final List<com.tencent.mobileqq.cardcontainer.data.a> Q1(List<BusinessFeedData> mayKnowList) {
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList;
        ArrayList arrayListOf;
        if (mayKnowList == null || mayKnowList.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BusinessFeedData> it = mayKnowList.iterator();
        while (it.hasNext()) {
            CellRecommItem cellRecommItem = it.next().cellRecommItem;
            if (cellRecommItem == null) {
                it.remove();
            } else {
                String valueOf = String.valueOf(cellRecommItem.userInfo.uin);
                String str = cellRecommItem.extendinfo.get(CellRecommItem.EXTEND_KEY_ALG);
                if (str == null) {
                    str = "";
                }
                CardType cardType = CardType.AvatarPlusOneBtn;
                String T1 = T1(valueOf);
                String str2 = cellRecommItem.userInfo.nickName;
                String str3 = cellRecommItem.content;
                Intrinsics.checkNotNullExpressionValue(str3, "recommItem.content");
                String W1 = W1(valueOf, str3, str);
                String str4 = cellRecommItem.userInfo.nickName;
                Intrinsics.checkNotNullExpressionValue(str4, "recommItem.userInfo.nickName");
                String R1 = R1(valueOf, str4, str);
                String str5 = cellRecommItem.content;
                Intrinsics.checkNotNullExpressionValue(str5, "recommItem.content");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.cardcontainer.data.b(T1, valueOf, str2, str3, null, W1, R1, S1(valueOf, str5, str)));
                ContainerData g16 = com.tencent.mobileqq.cardcontainer.b.f201051a.g(new ContainerData(100, cardType, "pymk", "", "", "", arrayListOf, "", ""));
                if (g16 != null) {
                    arrayList.add(g16);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void O1() {
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void P1(boolean fromCache) {
    }
}
