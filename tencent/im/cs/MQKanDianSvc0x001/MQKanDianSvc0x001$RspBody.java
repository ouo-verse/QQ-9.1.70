package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MQKanDianSvc0x001$RspBody extends MessageMicro<MQKanDianSvc0x001$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_error_num", "rpt_msg_words", "rpt_msg_articles"}, new Object[]{0, null, null}, MQKanDianSvc0x001$RspBody.class);
    public final PBInt32Field int32_error_num = PBField.initInt32(0);
    public final PBRepeatMessageField<WordsOfCut> rpt_msg_words = PBField.initRepeatMessage(WordsOfCut.class);
    public final PBRepeatMessageField<ArticleInfo> rpt_msg_articles = PBField.initRepeatMessage(ArticleInfo.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ArticleInfo extends MessageMicro<ArticleInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_subject", "str_abstract", "str_content_url"}, new Object[]{"", "", ""}, ArticleInfo.class);
        public final PBStringField str_subject = PBField.initString("");
        public final PBStringField str_abstract = PBField.initString("");
        public final PBStringField str_content_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WordsOfCut extends MessageMicro<WordsOfCut> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_str_words"}, new Object[]{""}, WordsOfCut.class);
        public final PBRepeatField<String> rpt_str_words = PBField.initRepeat(PBStringField.__repeatHelper__);
    }
}
