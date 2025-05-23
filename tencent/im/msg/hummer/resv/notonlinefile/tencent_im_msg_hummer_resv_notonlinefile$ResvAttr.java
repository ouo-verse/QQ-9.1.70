package tencent.im.msg.hummer.resv.notonlinefile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class tencent_im_msg_hummer_resv_notonlinefile$ResvAttr extends MessageMicro<tencent_im_msg_hummer_resv_notonlinefile$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"bytes_crm_buf", "nt_ext", "uint32_file_from_scene"}, new Object[]{ByteStringMicro.EMPTY, null, 0}, tencent_im_msg_hummer_resv_notonlinefile$ResvAttr.class);
    public final PBBytesField bytes_crm_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public tencent_im_msg_hummer_resv_notonlinefile$NTExt nt_ext = new MessageMicro<tencent_im_msg_hummer_resv_notonlinefile$NTExt>() { // from class: tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile$NTExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"c2c_msg_seq"}, new Object[]{0L}, tencent_im_msg_hummer_resv_notonlinefile$NTExt.class);
        public final PBUInt64Field c2c_msg_seq = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_file_from_scene = PBField.initUInt32(0);
}
