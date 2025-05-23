package trpc.yes.common;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$QQNearbyUserInfo extends MessageMicro<UserProxyCmdOuterClass$QQNearbyUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public UserProxyCmdOuterClass$Address address;
    public final PBBytesField birthday;
    public final PBBytesField city_id;
    public final PBUInt32Field city_zone_id;
    public final PBStringField company;
    public final PBUInt32Field constellation;
    public final PBRepeatMessageField<UserProxyCmdOuterClass$NearbyTag> interests;
    public final PBUInt32Field job;
    public UserProxyCmdOuterClass$Location location;
    public final PBUInt32Field marriage;
    public final PBStringField school;
    public final PBStringField signature;
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field age = PBField.initUInt32(0);

    static {
        String[] strArr = {"nick", "logo", INetChannelCallback.KEY_TINY_ID, "gender", "age", "birthday", "signature", "marriage", "job", IProfileProtocolConst.KEY_COMPANY, "school", PoiDbManager.COL_POI_CITY_ID, "city_zone_id", IProfileProtocolConst.KET_INTERESTS, "location", LpReport_UserInfo_dc02148.CONSTELLATION, "address"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 144, 162}, strArr, new Object[]{"", "", 0L, 0, 0, byteStringMicro, "", 0, 0, "", "", byteStringMicro, 0, null, null, 0, null}, UserProxyCmdOuterClass$QQNearbyUserInfo.class);
    }

    public UserProxyCmdOuterClass$QQNearbyUserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.birthday = PBField.initBytes(byteStringMicro);
        this.signature = PBField.initString("");
        this.marriage = PBField.initUInt32(0);
        this.job = PBField.initUInt32(0);
        this.company = PBField.initString("");
        this.school = PBField.initString("");
        this.city_id = PBField.initBytes(byteStringMicro);
        this.city_zone_id = PBField.initUInt32(0);
        this.interests = PBField.initRepeatMessage(UserProxyCmdOuterClass$NearbyTag.class);
        this.location = new UserProxyCmdOuterClass$Location();
        this.constellation = PBField.initUInt32(0);
        this.address = new UserProxyCmdOuterClass$Address();
    }
}
