package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GetTroopAioTopAD$ReqBody extends MessageMicro<GetTroopAioTopAD$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_groupcode", "msg_app_info"}, new Object[]{0L, null}, GetTroopAioTopAD$ReqBody.class);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0);
    public GetTroopAioTopAD$AppInfo msg_app_info = new MessageMicro<GetTroopAioTopAD$AppInfo>() { // from class: tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD$AppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plat_type", "str_app_version"}, new Object[]{1, ""}, GetTroopAioTopAD$AppInfo.class);
        public final PBEnumField plat_type = PBField.initEnum(1);
        public final PBStringField str_app_version = PBField.initString("");
    };
}
