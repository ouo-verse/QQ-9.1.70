package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$RoutingHead extends MessageMicro<im_msg$RoutingHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"c2c", VipFunCallConstants.KEY_GROUP}, new Object[]{null, null}, im_msg$RoutingHead.class);
    public im_msg$C2C c2c = new MessageMicro<im_msg$C2C>() { // from class: tencent.im.msg.im_msg$C2C
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"sender", "receiver", "c2c_relation"}, new Object[]{null, null, null}, im_msg$C2C.class);
        public im_common$User sender = new im_common$User();
        public im_common$User receiver = new im_common$User();
        public im_msg$C2CRelation c2c_relation = new MessageMicro<im_msg$C2CRelation>() { // from class: tencent.im.msg.im_msg$C2CRelation
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"c2c_type", "group_info", "token"}, new Object[]{0, null, null}, im_msg$C2CRelation.class);
            public final PBEnumField c2c_type = PBField.initEnum(0);
            public im_common$GroupInfo group_info = new im_common$GroupInfo();
            public im_common$Token token = new MessageMicro<im_common$Token>() { // from class: tencent.im.msg.im_common$Token
                public static final int BUF_FIELD_NUMBER = 1;
                public static final int C2C_TYPE_FIELD_NUMBER = 2;
                public static final int SERVICE_TYPE_FIELD_NUMBER = 3;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"buf", "c2c_type", "service_type"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, im_common$Token.class);
                public final PBBytesField buf = PBField.initBytes(ByteStringMicro.EMPTY);
                public final PBUInt32Field c2c_type = PBField.initUInt32(0);
                public final PBUInt32Field service_type = PBField.initUInt32(0);
            };
        };
    };
    public im_msg$Group group = new im_msg$Group();
}
