package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg$ContentHead extends MessageMicro<im_msg$ContentHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"pkg_num", "pkg_index", "seq", "date_time", QQHealthReportApiImpl.MSG_TYPE_KEY, "div_seq", "msgdb_uin", "msgdb_seq", "word_msg_seq", "msg_rand"}, new Object[]{1, 0, 0, 0, 0, 0, 0L, 0, 0, 0}, im_msg$ContentHead.class);
    public final PBUInt32Field pkg_num = PBField.initUInt32(1);
    public final PBUInt32Field pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field date_time = PBField.initUInt32(0);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBUInt32Field div_seq = PBField.initUInt32(0);
    public final PBUInt64Field msgdb_uin = PBField.initUInt64(0);
    public final PBUInt32Field msgdb_seq = PBField.initUInt32(0);
    public final PBUInt32Field word_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field msg_rand = PBField.initUInt32(0);
}
