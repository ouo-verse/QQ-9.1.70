package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.vas.VasUserData;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class kua_kua_hb_srv$TopicMatchRequest extends MessageMicro<kua_kua_hb_srv$TopicMatchRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66}, new String[]{"clientAttr", "hbTopic", "userAnswer", "hbListId", "grapUin", "sendUin", IProfileCardConst.KEY_FROM_TYPE, "groupId"}, new Object[]{null, "", "", "", "", "", 0L, ""}, kua_kua_hb_srv$TopicMatchRequest.class);
    public kua_kua_hb_srv$ClientAttr clientAttr = new MessageMicro<kua_kua_hb_srv$ClientAttr>() { // from class: tencent.im.qqwallet.kua_kua_hb_srv$ClientAttr
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"osType", VasUserData.Key.QQ_VER, "skeyType", "skey"}, new Object[]{0L, "", 0L, ""}, kua_kua_hb_srv$ClientAttr.class);
        public final PBInt64Field osType = PBField.initInt64(0);
        public final PBStringField qqVer = PBField.initString("");
        public final PBInt64Field skeyType = PBField.initInt64(0);
        public final PBStringField skey = PBField.initString("");
    };
    public final PBStringField hbTopic = PBField.initString("");
    public final PBStringField userAnswer = PBField.initString("");
    public final PBStringField hbListId = PBField.initString("");
    public final PBStringField grapUin = PBField.initString("");
    public final PBStringField sendUin = PBField.initString("");
    public final PBInt64Field fromType = PBField.initInt64(0);
    public final PBStringField groupId = PBField.initString("");
}
