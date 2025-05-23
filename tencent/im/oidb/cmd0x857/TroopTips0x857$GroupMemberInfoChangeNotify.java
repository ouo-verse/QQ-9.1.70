package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GroupMemberInfoChangeNotify extends MessageMicro<TroopTips0x857$GroupMemberInfoChangeNotify> {
    public static final int GET_ALL = 2;
    public static final int GET_CHANGED_MEMBER = 1;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"client_mode", "member_infos"}, new Object[]{0, null}, TroopTips0x857$GroupMemberInfoChangeNotify.class);
    public final PBUInt32Field client_mode = PBField.initUInt32(0);
    public final PBRepeatMessageField<MemberInfo> member_infos = PBField.initRepeatMessage(MemberInfo.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MemberIcon extends MessageMicro<MemberIcon> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 122}, new String[]{IPreloadServiceProxy.KEY_RESID, VasQQSettingMeImpl.EXPIRE_TIME, QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, MsgBackupExtraEntity.TABLE_NAME}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, MemberIcon.class);
        public final PBUInt32Field res_id = PBField.initUInt32(0);
        public final PBUInt64Field expire_time = PBField.initUInt64(0);
        public final PBUInt32Field biz_id = PBField.initUInt32(0);
        public final PBBytesField ex_info = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MemberInfo extends MessageMicro<MemberInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_icon_info"}, new Object[]{0L, null}, MemberInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<MemberIcon> rpt_icon_info = PBField.initRepeatMessage(MemberIcon.class);
    }
}
