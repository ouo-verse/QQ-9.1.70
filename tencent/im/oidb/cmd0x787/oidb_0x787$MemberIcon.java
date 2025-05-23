package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x787$MemberIcon extends MessageMicro<oidb_0x787$MemberIcon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 122}, new String[]{IPreloadServiceProxy.KEY_RESID, VasQQSettingMeImpl.EXPIRE_TIME, QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, MsgBackupExtraEntity.TABLE_NAME}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, oidb_0x787$MemberIcon.class);
    public final PBUInt32Field res_id = PBField.initUInt32(0);
    public final PBUInt64Field expire_time = PBField.initUInt64(0);
    public final PBUInt32Field biz_id = PBField.initUInt32(0);
    public final PBBytesField ex_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
