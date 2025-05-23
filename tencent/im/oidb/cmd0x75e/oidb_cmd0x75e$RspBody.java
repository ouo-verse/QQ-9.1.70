package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x75e$RspBody extends MessageMicro<oidb_cmd0x75e$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "msg_rsp_article"}, new Object[]{0L, null}, oidb_cmd0x75e$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0x75e$RspArticle msg_rsp_article = new MessageMicro<oidb_cmd0x75e$RspArticle>() { // from class: tencent.im.oidb.cmd0x75e.oidb_cmd0x75e$RspArticle
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"enum_op_type", "rpt_article_info"}, new Object[]{1, null}, oidb_cmd0x75e$RspArticle.class);
        public final PBEnumField enum_op_type = PBField.initEnum(1);
        public final PBRepeatMessageField<oidb_cmd0x75e$ArticleInfo> rpt_article_info = PBField.initRepeatMessage(oidb_cmd0x75e$ArticleInfo.class);
    };
}
