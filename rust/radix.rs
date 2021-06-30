fn count_sort(list: &mut Vec<f64>, num: f64) {
    let length: usize = list.len();
    let mut output:  Vec<f64> = vec![0.0; length];
    let mut count:  Vec<f64> = vec![0.0; 10];

    for i in 0..length {
        let index: f64 = list[i] / num;
        count[(index % 10.0) as usize] += 1.0;
    }

    for j in 0..10 {
        count[j] += count[(j + 10 - 1) % 10];
    }

    let mut k = (length - 1) as i64;
    while k >= 0 {
        let index: f64 = list[k as usize] / num;
        let bar: usize = (index % 10.0) as usize;
        let l: f64 = length as f64;
        output[((count[bar] + l - 1.0) % l) as usize] = list[k as usize];
        count[bar] -= 1.0;
        k -= 1;
    }

    for l in 0..length {
        list[l] = output[l];
    }
}

fn radix_sort(input: &mut Vec<f64>) -> Vec<f64> {
    let mut list: Vec<f64> = input.clone();
    let max: f64 = list.iter().cloned().fold(-1. / 0., f64::max);
    let mut num: f64 = 1.0;
    while max / num > 0.0 {
        count_sort(&mut list, num);
        num *= 10.0;
    }
    return list;
}

fn main() {
    let mut input: Vec<f64> = vec![345.0, 456.0, 75.67, 345.0, 3.3, 35.0, 34.6];
    let new: Vec<f64> = radix_sort(&mut input);
    println!("{:?}", input);
    println!("{:?}", new);
}
