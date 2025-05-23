package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x897$GroupVisitorInfo extends MessageMicro<cmd0x897$GroupVisitorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_group_next_visitor", "uint32_flag", "rpt_msg_visitor_info"}, new Object[]{null, 0, null}, cmd0x897$GroupVisitorInfo.class);
    public cmd0x897$GroupNextVisitor msg_group_next_visitor = new MessageMicro<cmd0x897$GroupNextVisitor>() { // from class: tencent.im.oidb.cmd0x897.cmd0x897$GroupNextVisitor
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48}, new String[]{"msg_group_uin_code", "uint64_next_visitor", "msg_req_field", "uint32_max_count", "uint32_administrator_field", "uint32_guest_field"}, new Object[]{null, 0L, null, 0, 0, 0}, cmd0x897$GroupNextVisitor.class);
        public cmd0x897$GroupUinCode msg_group_uin_code = new MessageMicro<cmd0x897$GroupUinCode>() { // from class: tencent.im.oidb.cmd0x897.cmd0x897$GroupUinCode
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_uin", "uint64_group_code"}, new Object[]{0L, 0L}, cmd0x897$GroupUinCode.class);
            public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        };
        public final PBUInt64Field uint64_next_visitor = PBField.initUInt64(0);
        public cmd0x897$VisitorInfo msg_req_field = new MessageMicro<cmd0x897$VisitorInfo>() { // from class: tencent.im.oidb.cmd0x897.cmd0x897$VisitorInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_visitor_uin", "uint32_visitor_faceid", "string_visitor_nick", "uint32_role", "uint32_guest_flag"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, 0}, cmd0x897$VisitorInfo.class);
            public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_visitor_faceid = PBField.initUInt32(0);
            public final PBBytesField string_visitor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_role = PBField.initUInt32(0);
            public final PBUInt32Field uint32_guest_flag = PBField.initUInt32(0);
        };
        public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_administrator_field = PBField.initUInt32(0);
        public final PBUInt32Field uint32_guest_field = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x897$VisitorInfo> rpt_msg_visitor_info = PBField.initRepeatMessage(cmd0x897$VisitorInfo.class);
}
