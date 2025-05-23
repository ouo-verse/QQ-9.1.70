package tencent.im.oidb.cmd0xf1f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf1f$ReqBody extends MessageMicro<oidb_cmd0xf1f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_article_item", "opt_type"}, new Object[]{null, 1}, oidb_cmd0xf1f$ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xf1f$ArticleItem> rpt_article_item = PBField.initRepeatMessage(oidb_cmd0xf1f$ArticleItem.class);
    public final PBEnumField opt_type = PBField.initEnum(1);
}
