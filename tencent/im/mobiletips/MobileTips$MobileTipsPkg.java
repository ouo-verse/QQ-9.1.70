package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes29.dex */
public final class MobileTips$MobileTipsPkg extends MessageMicro<MobileTips$MobileTipsPkg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"req", "rsp"}, new Object[]{null, null}, MobileTips$MobileTipsPkg.class);
    public MobileTips$ReqBody req = new MessageMicro<MobileTips$ReqBody>() { // from class: tencent.im.mobiletips.MobileTips$ReqBody
        public static final int TYPE_C2C = 1;
        public static final int TYPE_DISCUSS = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"peer_type", ProtocolDownloaderConstants.HEADER_FRIEND_UIN, "task_list"}, new Object[]{1, 0L, null}, MobileTips$ReqBody.class);
        public final PBEnumField peer_type = PBField.initEnum(1);
        public final PBUInt64Field peer_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<MobileTips$TaskInfo> task_list = PBField.initRepeatMessage(MobileTips$TaskInfo.class);
    };
    public MobileTips$RspBody rsp = new MobileTips$RspBody();
}
