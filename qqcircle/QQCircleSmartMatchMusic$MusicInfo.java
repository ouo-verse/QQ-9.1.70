package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$MusicInfo extends MessageMicro<QQCircleSmartMatchMusic$MusicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"albumInfo", "singerInfo", "songInfo", "lyricInfo", "subtitleInfo", "foreignlyric", "confInfo", "extInfo"}, new Object[]{null, null, null, null, null, null, null, null}, QQCircleSmartMatchMusic$MusicInfo.class);
    public QQCircleSmartMatchMusic$AlbumInfo albumInfo = new QQCircleSmartMatchMusic$AlbumInfo();
    public QQCircleSmartMatchMusic$SingerInfo singerInfo = new QQCircleSmartMatchMusic$SingerInfo();
    public QQCircleSmartMatchMusic$SongInfo songInfo = new QQCircleSmartMatchMusic$SongInfo();
    public QQCircleSmartMatchMusic$LyricInfo lyricInfo = new QQCircleSmartMatchMusic$LyricInfo();
    public QQCircleSmartMatchMusic$LyricInfo subtitleInfo = new QQCircleSmartMatchMusic$LyricInfo();
    public QQCircleSmartMatchMusic$LyricInfo foreignlyric = new QQCircleSmartMatchMusic$LyricInfo();
    public QQCircleSmartMatchMusic$ConfInfo confInfo = new QQCircleSmartMatchMusic$ConfInfo();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
}
