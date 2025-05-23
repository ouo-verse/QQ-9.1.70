package tencent.im.new_year_2014;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Unisso$UniSsoServerRsp extends MessageMicro<Unisso$UniSsoServerRsp> {
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPDATA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "comm", "rspdata"}, new Object[]{0L, "", null, ByteStringMicro.EMPTY}, Unisso$UniSsoServerRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public Unisso$UniSsoServerRspComm comm = new MessageMicro<Unisso$UniSsoServerRspComm>() { // from class: tencent.im.new_year_2014.Unisso$UniSsoServerRspComm
        public static final int DELAYMS_FIELD_NUMBER = 1;
        public static final int PACKAGESIZE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"delayms", "packagesize"}, new Object[]{0, 0}, Unisso$UniSsoServerRspComm.class);
        public final PBUInt32Field delayms = PBField.initUInt32(0);
        public final PBUInt32Field packagesize = PBField.initUInt32(0);
    };
    public final PBBytesField rspdata = PBField.initBytes(ByteStringMicro.EMPTY);
}
