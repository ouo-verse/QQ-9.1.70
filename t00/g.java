package t00;

import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {
    private static WSStatisticsReporter.Builder a() {
        return new WSStatisticsReporter.Builder().setPushId(v.b().c()).setFlush(true);
    }

    private static void b(String str, WSStatisticsReporter.Builder builder) {
        builder.build(str).report();
    }

    public static void c(c cVar) {
        if (cVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("player_type", String.valueOf(cVar.f435189a));
        hashMap.put("video_play_scene", cVar.f435190b);
        hashMap.put("video_id", cVar.f435191c);
        hashMap.put("video_file_id", cVar.f435192d);
        hashMap.put("video_width", String.valueOf(cVar.f435193e));
        hashMap.put("video_height", String.valueOf(cVar.f435194f));
        hashMap.put("video_url", cVar.f435196h);
        hashMap.put("video_url_host", cVar.f435197i);
        hashMap.put("video_format", cVar.f435195g);
        hashMap.put("video_duration_ms", String.valueOf(cVar.f435199k));
        hashMap.put("video_file_size", String.valueOf(cVar.f435198j));
        hashMap.put("video_bit_rate", String.valueOf(cVar.f435202n));
        hashMap.put("video_codec", cVar.f435203o);
        hashMap.put("video_profile", cVar.f435204p);
        hashMap.put("video_fps", String.valueOf(cVar.f435205q));
        hashMap.put("video_quality", String.valueOf(cVar.f435206r));
        hashMap.put("audio_codec", cVar.f435207s);
        hashMap.put("audio_profile", cVar.f435208t);
        hashMap.put("is_hit_cache", cVar.f435209u ? "1" : "0");
        hashMap.put("is_pre_download_hit", cVar.f435210v ? "1" : "0");
        hashMap.put("preload_status", String.valueOf(cVar.f435211w));
        hashMap.put("second_buffer_time", String.valueOf(cVar.f435212x));
        hashMap.put("second_buffer_count", String.valueOf(cVar.f435213y));
        hashMap.put("list_speed_kbs", cVar.H);
        hashMap.put("max_speed_kbs", String.valueOf(cVar.I));
        hashMap.put("min_speed_kbs", String.valueOf(cVar.J));
        hashMap.put("average_speed_kbs", String.valueOf(cVar.K));
        hashMap.put("downloader_info", cVar.L);
        hashMap.put("downloader_file_size", String.valueOf(cVar.M));
        hashMap.put("preloader_info", cVar.N);
        hashMap.put("preloader_file_size", String.valueOf(cVar.O));
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME, String.valueOf(cVar.B));
        hashMap.put("last_location_ms", String.valueOf(cVar.C));
        hashMap.put("decode_hw_sw", String.valueOf(cVar.E));
        hashMap.put("decoder_strategy_type", String.valueOf(cVar.F));
        hashMap.put("selected_video_spec_reason", String.valueOf(cVar.G));
        hashMap.put("is_peak_period", cVar.P ? "1" : "0");
        hashMap.put("emergency_time_sec", String.valueOf(cVar.Q));
        hashMap.put("safe_play_time_sec", String.valueOf(cVar.R));
        hashMap.put("preload_play_time_sec", String.valueOf(cVar.S));
        hashMap.put("video_prepare_time", String.valueOf(cVar.f435214z));
        hashMap.put("skip_frames_total_count", String.valueOf(cVar.A));
        hashMap.put("error_code", cVar.T);
        hashMap.put("error_detail_info", cVar.U);
        hashMap.put("hw_codec_error_code", cVar.V);
        hashMap.put("is_change_hw_backup", cVar.W ? "1" : "0");
        hashMap.put("enable_codec_reuse", cVar.D ? "1" : "0");
        b("gzh_player_performance", a().addParams(hashMap));
    }

    public static void d(WSPlayerPreloaderReportData wSPlayerPreloaderReportData) {
        if (wSPlayerPreloaderReportData == null) {
            return;
        }
        x.f("WS_VIDEO_REPORT", "[WSPlayerReporter.java][reportVideoPreloader] reportData:" + wSPlayerPreloaderReportData);
        HashMap hashMap = new HashMap();
        hashMap.put("video_url", wSPlayerPreloaderReportData.getVideoUrl());
        hashMap.put("video_duration_ms", String.valueOf(wSPlayerPreloaderReportData.getVideoDurationMs()));
        hashMap.put("video_file_size", String.valueOf(wSPlayerPreloaderReportData.getVideoFileSize()));
        hashMap.put("preloader_info", wSPlayerPreloaderReportData.getVideoPreloaderInfo());
        b("gzh_video_preloader", a().addParams(hashMap));
    }
}
