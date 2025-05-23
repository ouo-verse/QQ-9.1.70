package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$UserID;

/* loaded from: classes29.dex */
public final class QQCircleProfile$SetProfileReq extends MessageMicro<QQCircleProfile$SetProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 58, 64, 72, 82, 90, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170, 178, 186, 192, 202, 210, 216}, new String[]{"extInfo", "infoTypes", "sign", "showTagList", "pattonType", "groupIDList", "nick", "gender", LpReport_UserInfo_dc02148.CONSTELLATION, "school", IProfileProtocolConst.KEY_COMPANY, "location", "locationCode", "guildId", "gwExpireTime", "hideSchool", "gwStartTime", "uid", "logo", "certificationDesc", "blueCertifiDesc", "login_ip", "login_ip_location", "certification_type", "user_id", QCircleDaTongConstant.ElementParamValue.QRCODE, "bigVType"}, new Object[]{null, 0, "", null, 0, 0L, "", 0, 0, "", "", "", "", 0L, 0L, 0, 0L, "", "", "", "", "", "", 0, null, ByteStringMicro.EMPTY, 0}, QQCircleProfile$SetProfileReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Integer> infoTypes = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBStringField sign = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> showTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBRepeatField<Long> groupIDList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBInt32Field constellation = PBField.initInt32(0);
    public final PBStringField school = PBField.initString("");
    public final PBStringField company = PBField.initString("");
    public final PBStringField location = PBField.initString("");
    public final PBStringField locationCode = PBField.initString("");
    public final PBUInt64Field guildId = PBField.initUInt64(0);
    public final PBInt64Field gwExpireTime = PBField.initInt64(0);
    public final PBUInt32Field hideSchool = PBField.initUInt32(0);
    public final PBInt64Field gwStartTime = PBField.initInt64(0);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField certificationDesc = PBField.initString("");
    public final PBStringField blueCertifiDesc = PBField.initString("");
    public final PBStringField login_ip = PBField.initString("");
    public final PBStringField login_ip_location = PBField.initString("");
    public final PBUInt32Field certification_type = PBField.initUInt32(0);
    public FeedCloudMeta$UserID user_id = new MessageMicro<FeedCloudMeta$UserID>() { // from class: feedcloud.FeedCloudMeta$UserID
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"id", "start_time", "end_time"}, new Object[]{"", 0L, 0L}, FeedCloudMeta$UserID.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f398466id = PBField.initString("");
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
    };
    public final PBBytesField qr_code = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field bigVType = PBField.initUInt32(0);
}
