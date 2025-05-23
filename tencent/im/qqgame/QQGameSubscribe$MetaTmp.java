package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameSubscribe$MetaTmp extends MessageMicro<QQGameSubscribe$MetaTmp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146}, new String[]{"arkApp", "careConfId", VasWebviewConstants.KEY_ADTAG, "appID", IQWalletPreferenceApi.KEY_ICON_URL, "giftBgImg", "giftId", "lbtnImg", "lbtnURL", "logo", "majorTxt", "msgLink", "picUrl", "rbtnImg", "rbtnUrl", "title", "giftItem", "source"}, new Object[]{"", 0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", null, ""}, QQGameSubscribe$MetaTmp.class);
    public final PBStringField arkApp = PBField.initString("");
    public final PBInt32Field careConfId = PBField.initInt32(0);
    public final PBStringField adTag = PBField.initString("");
    public final PBStringField appID = PBField.initString("");
    public final PBStringField bgURL = PBField.initString("");
    public final PBStringField giftBgImg = PBField.initString("");
    public final PBStringField giftId = PBField.initString("");
    public final PBStringField lbtnImg = PBField.initString("");
    public final PBStringField lbtnURL = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField majorTxt = PBField.initString("");
    public final PBStringField msgLink = PBField.initString("");
    public final PBStringField picUrl = PBField.initString("");
    public final PBStringField rbtnImg = PBField.initString("");
    public final PBStringField rbtnUrl = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QQGameSubscribe$SubscribeArkGiftItem> giftItem = PBField.initRepeatMessage(QQGameSubscribe$SubscribeArkGiftItem.class);
    public final PBStringField source = PBField.initString("");
}
