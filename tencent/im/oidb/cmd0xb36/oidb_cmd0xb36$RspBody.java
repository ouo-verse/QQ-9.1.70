package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb36$RspBody extends MessageMicro<oidb_cmd0xb36$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"group_id", "toast", "chain_list"}, new Object[]{0L, null, null}, oidb_cmd0xb36$RspBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public oidb_cmd0xb36$ToastInfo toast = new oidb_cmd0xb36$ToastInfo();
    public oidb_cmd0xb36$ChainList chain_list = new MessageMicro<oidb_cmd0xb36$ChainList>() { // from class: tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$ChainList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"infos", "group_role", "homework_role"}, new Object[]{null, 0, 0}, oidb_cmd0xb36$ChainList.class);
        public final PBRepeatMessageField<oidb_cmd0xb36$ChainInfo> infos = PBField.initRepeatMessage(oidb_cmd0xb36$ChainInfo.class);
        public final PBUInt32Field group_role = PBField.initUInt32(0);
        public final PBUInt32Field homework_role = PBField.initUInt32(0);
    };
}
