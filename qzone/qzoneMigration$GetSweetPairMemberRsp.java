package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qzoneMigration$GetSweetPairMemberRsp extends MessageMicro<qzoneMigration$GetSweetPairMemberRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"sweet_isyz", "sweet_yzdays", "sweet_closetime", "sweet_close_timestp"}, new Object[]{0, 0, "", 0L}, qzoneMigration$GetSweetPairMemberRsp.class);
    public final PBInt32Field sweet_isyz = PBField.initInt32(0);
    public final PBInt32Field sweet_yzdays = PBField.initInt32(0);
    public final PBStringField sweet_closetime = PBField.initString("");
    public final PBInt64Field sweet_close_timestp = PBField.initInt64(0);
}
